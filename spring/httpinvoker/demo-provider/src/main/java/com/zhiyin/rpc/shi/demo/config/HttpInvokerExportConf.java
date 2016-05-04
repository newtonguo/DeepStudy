package com.zhiyin.rpc.shi.demo.config;

import com.zhiyin.rpc.shi.demo.filter.IpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by wangqinghui on 2016/4/29.
 */
@Configuration
@ImportResource("classpath:config/remote-servlet.xml")
public class HttpInvokerExportConf {

    @Bean
    public IpFilter remoteIpFilter() {
        return new IpFilter();
    }
}
