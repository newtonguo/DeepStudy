//package com.zhiyin.cloudeye.demo;
//
//import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.embedded.ServletRegistrationBean;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//class HystrixConfiguration extends SpringBootServletInitializer {
//
//    /**
//     * to expose stream endpoint
//     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
//    }
//
//}