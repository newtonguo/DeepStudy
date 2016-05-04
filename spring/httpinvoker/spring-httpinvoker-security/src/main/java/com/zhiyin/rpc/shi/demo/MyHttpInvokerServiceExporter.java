package com.zhiyin.rpc.shi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.util.NestedServletException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpInvoker接口暴露类，添加验证支持
 * 继承自spring的HttpInvokerServiceExporter类，重写其handleRequest()方法
 */
public class MyHttpInvokerServiceExporter extends HttpInvokerServiceExporter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpInvokerServiceExporter.class);
 
    /**
     * 重写处理方法，添加安全认证
     */
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RemoteInvocation invocation = readRemoteInvocation(request);
            if(!isSecurityRequest(invocation)){
                String message = "Security Forbidden,this is not security request";
                try {
                    response.getWriter().println(message);
                } catch (IOException ex) {
                    LOGGER.error(ex.getMessage(),ex);
                }
                return;
            }
 
            RemoteInvocationResult result = invokeAndCreateResult(invocation, getProxy());
            writeRemoteInvocationResult(request, response, result);
        } catch (ClassNotFoundException e) {
            throw new NestedServletException("Class not found during deserialization", e);
        }
    }
 
    /**
     * 安全认证方法
     */
    protected boolean isSecurityRequest(RemoteInvocation invocation){
        try {
            String username = invocation.getAttribute(MyHttpInvokerAuthInfo.USERNAME_KEY).toString();
            return MyHttpInvokerAuthInfo.validatePassword(username, invocation.getAttributes());
        } catch (Exception e) {
            LOGGER.error("读取验证信息失败...", e.getMessage());
        }
        return false;
    }
}   