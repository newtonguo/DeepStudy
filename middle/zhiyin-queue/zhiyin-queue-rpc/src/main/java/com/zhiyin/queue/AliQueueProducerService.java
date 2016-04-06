package com.zhiyin.queue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Ali Queue服务接口
 */
@RestController
@RequestMapping("/aliq")
@Slf4j
@Service

public class AliQueueProducerService {


    @Autowired
    protected RestTemplate restTemplate;

    protected String serviceUrl;


    public AliQueueProducerService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show
     * this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        log.warn("The RestTemplate request factory is "
                + restTemplate.getRequestFactory());
    }

    public String postAliEvent(String accountNumber) {

        log.info("findByNumber() invoked: for " + accountNumber);
        return restTemplate.postForObject(serviceUrl + "/ali/event/put","",
                String.class);
    }

    public String okTest() {
        return restTemplate.getForObject(serviceUrl + "/ali/oktest",
                String.class);
    }

}