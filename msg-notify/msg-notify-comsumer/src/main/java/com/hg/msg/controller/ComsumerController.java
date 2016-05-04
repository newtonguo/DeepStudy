package com.hg.msg.controller;

import com.alibaba.fastjson.JSON;
import com.hg.msg.config.serveice.MsgNotifyRestService;
import com.hg.msg.entity.MsgUserNotify;
import com.hg.msg.service.IMsgNotifyInfoService;
import com.hg.msg.service.IMsgNotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangqinghui on 2016/3/29.
 */
@Slf4j
@RestController
public class ComsumerController {

    // rest服务调用
    @Autowired
    protected MsgNotifyRestService msgNotifyRestService;

    // 使用dubbo的服务
    @com.alibaba.dubbo.config.annotation.Reference
    private IMsgNotifyService msgNotifyService;

    @RequestMapping("/getUserNotify")
    public String greeting() {
        log.info("test ok.");
        List<MsgUserNotify> tmp = msgNotifyRestService.getUserNotify(112L);
        log.info(JSON.toJSONString(tmp));

        return JSON.toJSONString(tmp);
    }



    @RequestMapping("/testdubbo")
    public String testdubbo() {

        List<MsgUserNotify> tmp = msgNotifyService.getUserNotify(112L);
        log.info(JSON.toJSONString(tmp));

        tmp = msgNotifyService.getUserNotify(2L);

        return JSON.toJSONString(tmp);
    }

}
