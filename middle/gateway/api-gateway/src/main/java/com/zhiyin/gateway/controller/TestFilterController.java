package com.zhiyin.gateway.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hg on 2016/3/29.
 */
@Slf4j
@RestController("/local/test/")
public class TestFilterController {


    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public String hello(@PathVariable("name") String name) {
        return "hello" + name;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String helloPost(@RequestBody User user) {
        log.info("hello" + user.getName());
        return "hello " + user.getName()+"!";
    }



}
