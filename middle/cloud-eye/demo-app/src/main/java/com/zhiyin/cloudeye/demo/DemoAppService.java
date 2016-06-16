package com.zhiyin.cloudeye.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker
@SpringBootApplication
public class DemoAppService {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoAppService.class).web(true).run(args);

//        SpringApplication notificationMicroService = new SpringApplication(DemoAppService.class);
//        notificationMicroService.addListeners(new ApplicationPidFileWriter("notification-micro-service.pid"));
//        notificationMicroService.run(args);
    }

}
