package com.hg.msg.controller;

import com.alibaba.fastjson.JSON;
import com.hg.msg.entity.MsgUserNotify;
import com.hg.msg.rest.MsgNotifyRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangqinghui on 2016/3/29.
 */
@Slf4j
@RestController
public class ComsumerController {

    @Autowired
    protected MsgNotifyRestService msgNotifyRestService;

    @RequestMapping("/getUserNotify")
    public String greeting() {
        log.info("test ok.");
        List<MsgUserNotify> tmp = msgNotifyRestService.getUserNotify(112L);
        log.info(JSON.toJSONString(tmp));

        return JSON.toJSONString(tmp);
    }

}
