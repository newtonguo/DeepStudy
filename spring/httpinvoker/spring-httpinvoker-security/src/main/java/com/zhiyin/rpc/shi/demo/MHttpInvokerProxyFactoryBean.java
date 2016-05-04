package com.zhiyin.rpc.shi.demo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * 详情参见Spring的HttpInvokerProxyFactoryBean类，本类与其完全一致
 */
public class MHttpInvokerProxyFactoryBean extends MyHttpInvokerClientInterceptor implements FactoryBean<Object> {
 
    private Object serviceProxy;
 
 
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        if (getServiceInterface() == null) {
            throw new IllegalArgumentException("Property 'serviceInterface' is required");
        }
        this.serviceProxy = new ProxyFactory(getServiceInterface(), this).getProxy(getBeanClassLoader());
    }
 
 
    public Object getObject() {
        return this.serviceProxy;
    }
 
    public Class<?> getObjectType() {
        return getServiceInterface();
    }
 
    public boolean isSingleton() {
        return true;
    }
}