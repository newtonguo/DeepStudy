package com.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        boolean useJavaConfig  = true;
        ApplicationContext ctx = null;

        //Showing examples of both Xml and Java based configuration
        if (useJavaConfig ) {
                ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        }
        else {
                ctx = new GenericXmlApplicationContext("/spring-config/spring-cache.xml");
        }
        ctx = new GenericXmlApplicationContext("classpath:spring-config/spring-cache.xml");

        HelloService helloService = ctx.getBean("helloService", HelloService.class);

        //First method execution using key="Josh", not cached
        System.out.println("message: " + helloService.getMessage("Josh"));

        //Second method execution using key="Josh", still not cached
        System.out.println("message: " + helloService.getMessage("Josh"));

        //First method execution using key="Joshua", not cached
        System.out.println("message: " + helloService.getMessage("Joshua"));

        //Second method execution using key="Joshua", cached
        System.out.println("message: " + helloService.getMessage("Joshua"));

        System.out.println("Done.");
    }

}