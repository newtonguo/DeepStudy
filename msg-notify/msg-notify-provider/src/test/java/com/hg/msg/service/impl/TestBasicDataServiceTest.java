package com.hg.msg.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hg.msg.ProviderApplication;
import com.hg.msg.entity.MsgUserNotify;
import com.hg.msg.service.IMsgNotifyService;
import com.hg.msg.service.ITestBasicDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by wangqinghui on 2016/3/29.
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ProviderApplication.class})
@WebAppConfiguration
@EnableAuthorizationServer
@EnableResourceServer
public class TestBasicDataServiceTest {


    @Autowired
    private ITestBasicDataService testBasicDataService;

    List<MsgUserNotify> userNotifyList = Lists.newArrayList();


    @Test
    public void testRemindSuit() throws InterruptedException {

        PageInfo result = testBasicDataService.selectIncByTest(0L, 1105L);

        Assert.assertTrue( result.getPageSize() == result.getSize());

        result = testBasicDataService.selectIncByTest(1L, 1120L);

        log.info(JSON.toJSONString(result.getList()));

    }
}