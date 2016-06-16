package com.zhiyin.cloudeye.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class HelloService {

    @HystrixCommand
    public String random(){
        return UUID.randomUUID().toString();
    }

}
