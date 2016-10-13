package com.zhiyin.hds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableCircuitBreaker
@SpringBootApplication
@RestController
@EnableHystrixDashboard
@EnableFeignClients
public class HystrixClientApplication {

	@Autowired
	private IEmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(HystrixClientApplication.class, args);
	}

	@RequestMapping("/list")
	public String list() {
		return employeeService.list();
	}

	static class ApplicationConfig extends WebMvcConfigurerAdapter {

		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	}
}