package com.hg.msg.controller;

import com.hg.msg.service.impl.MsgNotifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by wangqinghui on 2016/3/29.
 */
@RestController
public class TestCon {

    @Resource
    private MsgNotifyService msgNotifyService;

    @RequestMapping(method = RequestMethod.GET, path = "/test" )
    public String greeting() {
        msgNotifyService.createAnnounce("sd",1L);
        return "sd";
    }


}
