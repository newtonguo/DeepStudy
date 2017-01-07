package org.springframework.cloud.config.server.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqinghui on 2016/12/26.
 */
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "config.client")
public class ConfigClientProperty {

    private String projectName;

    private String profile;

    @Data
    @NoArgsConstructor
    public static class ServerInvokerConfig {

        private String serverMark;

        private List<String> candidateServerMarks;

    }
}