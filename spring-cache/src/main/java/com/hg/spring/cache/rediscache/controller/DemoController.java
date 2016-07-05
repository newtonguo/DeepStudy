package com.hg.spring.cache.rediscache.controller;

import com.alibaba.fastjson.JSON;
import com.hg.spring.cache.rediscache.entity.User;
import com.hg.spring.cache.rediscache.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/test2")
    @ResponseBody
    public String testCache(){
        List<User> info = userInfoService.selectAll();

        return JSON.toJSONString(info);
    }
}
