package com.zhiyin.gateway;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;
import com.zhiyin.gateway.filter.GrayDispatcherFilter;
import com.zhiyin.gateway.filter.post.AutoResetInputStreamFilter;
import com.zhiyin.gateway.extend.MineHttpClientRibbonCommandFactory;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by hg on 16/5/24.
 */
@EnableHystrixDashboard
@EnableHystrix
@EnableAutoConfiguration
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication   {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(GatewayApplication.class);
//    }


    @Primary
        @Bean
        public RibbonCommandFactory<?> ribbonCommandFactory(
                SpringClientFactory clientFactory, ZuulProperties zuulProperties) {
            return new MineHttpClientRibbonCommandFactory(clientFactory, zuulProperties);
        }

    @Bean
    public GrayDispatcherFilter accessFilter2() {
        return new GrayDispatcherFilter();
    }
    @Bean
    public AutoResetInputStreamFilter accessFilter() {
        return new AutoResetInputStreamFilter();
    }

    @Component
    public static class MyCommandLineRunner implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            MonitoringHelper.initMocks();

            FilterLoader.getInstance().setCompiler(new GroovyCompiler());
            try {
                FileUtils.forceMkdir(new File("/opt/data/gateway/filter"));
                FilterFileManager.setFilenameFilter(new GroovyFileFilter());
                FilterFileManager.init(10,"/opt/data/gateway/filter");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }




}