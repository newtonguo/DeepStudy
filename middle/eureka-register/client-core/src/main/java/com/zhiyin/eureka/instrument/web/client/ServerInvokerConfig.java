package com.zhiyin.eureka.instrument.web.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by wangqinghui on 2016/12/26.
 */
@Data
@ConfigurationProperties(prefix = "ribbon.router.config")
public class ServerInvokerConfig {

    private String serverMark;

    private List<String> candidateServerMarks;

}
