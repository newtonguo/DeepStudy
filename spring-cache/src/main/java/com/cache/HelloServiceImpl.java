package com.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    /**
     * Using SpEL for conditional caching - only cache method executions when
     * the name is equal to "Joshua"
     */
	@Override
    @Cacheable(value="messageCache")
    public String getMessage(String name) {
        System.out.println("Executing HelloServiceImpl" +
                        ".getHelloMessage(\"" + name + "\")");

        return "Hello " + name + "!";
    }

}