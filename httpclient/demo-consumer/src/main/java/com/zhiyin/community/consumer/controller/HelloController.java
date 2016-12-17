package com.zhiyin.community.consumer.controller;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hg on 2016/3/29.
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello" )
    public String greeting() {

        return  "Hello";

    }


    @RequestMapping(method = RequestMethod.GET, path = "/hello_long" )
    public String greeting2() {
        try {
            Thread.sleep(10000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "Hello";

    }

}
