package com.witown.open.demo.remote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.witown.open.demo.remote.service.DemoService;

public class Test {

	public static void main(String[] args) {
		  ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring-httpinvoker.xml");
		  DemoService remotDemoService = (DemoService) context.getBean("remoteDemoService");
		  System.out.println(remotDemoService.getName());
	}
}
