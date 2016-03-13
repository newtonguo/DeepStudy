package com.zhiyin.event.engine.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableWebMvc
@EnableSwagger2
//@ComponentScan(basePackages ={"com.zhiyin.search.es.controller"})
/**
 *
 * @author hg 
 */
public class SwaggerConfig {

   /**
    * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple
    * swagger groups i.e. same code base multiple swagger resource listings.
    */
   @Bean
   public Docket customDocket(){
      return new Docket(DocumentationType.SWAGGER_2);

   }

}