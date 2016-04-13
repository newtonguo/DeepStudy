package com.hg.msg.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hg.msg.service.IMsgNotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangqinghui on 2016/3/29.
 */
@Slf4j
@RestController
public class TestokController {

//    @Resource
    @Reference
    private IMsgNotifyService msgNotifyService;

    @RequestMapping(method = RequestMethod.GET, path = "/testok" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String greeting() {
        log.info("test ok.");
       return msgNotifyService.testok("admin");
    }


}
