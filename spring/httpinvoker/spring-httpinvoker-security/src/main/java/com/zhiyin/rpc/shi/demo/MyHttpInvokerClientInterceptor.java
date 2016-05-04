package com.zhiyin.rpc.shi.demo;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.remoting.RemoteConnectFailureException;
import org.springframework.remoting.RemoteInvocationFailureException;
import org.springframework.remoting.httpinvoker.CommonsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerClientConfiguration;
import org.springframework.remoting.httpinvoker.HttpInvokerRequestExecutor;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationBasedAccessor;
import org.springframework.remoting.support.RemoteInvocationResult;

import java.io.InvalidClassException;
import java.lang.reflect.Method;
import java.net.ConnectException;

/**
 * 对Spring的HttpInvokerClientInterceptor类的重写
 * 添加 MyHttpInvokerAuthInfo 这一验证信息参数
 * 重写invoke()方法....
 * 重写getHttpInvokerRequestExecutor()方法，修改默认HttpInvokerRequestExecutor为CommonHttpInvokerRequestExecutor
 * 其余保持一致
 */
public class MyHttpInvokerClientInterceptor extends RemoteInvocationBasedAccessor
        implements MethodInterceptor, HttpInvokerClientConfiguration {
 
    private String codebaseUrl;
 
    private HttpInvokerRequestExecutor httpInvokerRequestExecutor;
 
    /**
     * 验证参数，存放服务端需要的认证信息，并用认证信息生成密钥
     */
    private MyHttpInvokerAuthInfo myHttpInvokerAuthInfo;
 
    public void setCodebaseUrl(String codebaseUrl) {
        this.codebaseUrl = codebaseUrl;
    }
 
    public String getCodebaseUrl() {
        return this.codebaseUrl;
    }
 
    public void setHttpInvokerRequestExecutor(HttpInvokerRequestExecutor httpInvokerRequestExecutor) {
        this.httpInvokerRequestExecutor = httpInvokerRequestExecutor;
    }
 
    /**
     * 返回一个HTTP请求执行器
     * 将默认执行器修改为CommonsHttpInvokerRequestExecutor
     */
    public HttpInvokerRequestExecutor getHttpInvokerRequestExecutor() {
        if (this.httpInvokerRequestExecutor == null) {
            CommonsHttpInvokerRequestExecutor executor = new CommonsHttpInvokerRequestExecutor();
            executor.setBeanClassLoader(getBeanClassLoader());
            this.httpInvokerRequestExecutor = executor;
        }
        return this.httpInvokerRequestExecutor;
    }
 
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        // Eagerly initialize the default HttpInvokerRequestExecutor, if needed.
        getHttpInvokerRequestExecutor();
    }
 
 
    /**
     * 重写调用方法，向RemoteInvocation中添加项目需要的验证信息
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (AopUtils.isToStringMethod(methodInvocation.getMethod())) {
            return "HTTP invoker proxy for service URL [" + getServiceUrl() + "]";
        }
 
        RemoteInvocation invocation = createRemoteInvocation(methodInvocation);
        try {
            //生成并写入验证信息
            if(myHttpInvokerAuthInfo != null){
                if(invocation.getAttributes() == null){
                    invocation.setAttributes(myHttpInvokerAuthInfo.getSecurityMap());
                }else{
                    invocation.getAttributes().putAll(myHttpInvokerAuthInfo.getSecurityMap());
                }
            }
        }catch (Exception e){
            logger.error("设置验证参数发生异常，请求将可能被服务端拦截...", e);
        }
 
        RemoteInvocationResult result = null;
        try {
            result = executeRequest(invocation, methodInvocation);
        }
        catch (Throwable ex) {
            throw convertHttpInvokerAccessException(ex);
        }
        try {
            return recreateRemoteInvocationResult(result);
        }
        catch (Throwable ex) {
            if (result.hasInvocationTargetException()) {
                throw ex;
            }
            else {
                throw new RemoteInvocationFailureException("Invocation of method [" + methodInvocation.getMethod() +
                        "] failed in HTTP invoker remote service at [" + getServiceUrl() + "]", ex);
            }
        }
    }
 
    protected RemoteInvocationResult executeRequest(
            RemoteInvocation invocation, MethodInvocation originalInvocation) throws Exception {
 
        return executeRequest(invocation);
    }
 
    protected RemoteInvocationResult executeRequest(RemoteInvocation invocation) throws Exception {
        return getHttpInvokerRequestExecutor().executeRequest(this, invocation);
    }
 
    protected RemoteAccessException convertHttpInvokerAccessException(Throwable ex) {
        if (ex instanceof ConnectException) {
            throw new RemoteConnectFailureException(
                    "Could not connect to HTTP invoker remote service at [" + getServiceUrl() + "]", ex);
        }
        else if (ex instanceof ClassNotFoundException || ex instanceof NoClassDefFoundError ||
                ex instanceof InvalidClassException) {
            throw new RemoteAccessException(
                    "Could not deserialize result from HTTP invoker remote service [" + getServiceUrl() + "]", ex);
        }
        else {
            throw new RemoteAccessException(
                    "Could not access HTTP invoker remote service at [" + getServiceUrl() + "]", ex);
        }
    }
 
    public MyHttpInvokerAuthInfo getMyHttpInvokerAuthInfo() {
        return myHttpInvokerAuthInfo;
    }
 
    public void setMyHttpInvokerAuthInfo(MyHttpInvokerAuthInfo myHttpInvokerAuthInfo) {
        this.myHttpInvokerAuthInfo = myHttpInvokerAuthInfo;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}