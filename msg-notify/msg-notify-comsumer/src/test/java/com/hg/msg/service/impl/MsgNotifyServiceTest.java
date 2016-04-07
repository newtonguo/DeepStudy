package com.hg.msg.service.impl;

import com.hg.Application;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by wangqinghui on 2016/3/29.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
@EnableAuthorizationServer
//@EnableWebSecurity
@EnableResourceServer
public class MsgNotifyServiceTest {


    Long testUserId = 11L ;

    Long UserAId = 111L ;
    Long UserBId = 112L ;
    Long adminId = 1L;

    Long ProductAId = 435L;

    @Autowired
    private MsgNotifyService msgNotifyService;

    @Test
    public void testAnnounce() throws Exception {

        msgNotifyService.createAnnounce("sd",adminId);
        msgNotifyService.pullAnnounce( testUserId );
//        msgNotifyService.selectUserNewNotify(testUserId, DateTime.now().minusHours(1).toDate());
    }

    @Test
    public void testCreateMessage() throws Exception {

        msgNotifyService.createMessage("msg",11L,12L) ;


    }

    @Test
    public void testCreateRemind() throws Exception {

        // 用户B评论Product A
        msgNotifyService.createRemind(ProductAId,"product","comment",UserBId,"用户B评论Product A");


    }


    @Test
    public void testSubscribe(){

        msgNotifyService.subscribe(1L,22L,"product","create_product");
    }

    @Test
    public void testPullRemind(){

        msgNotifyService.pullRemind(UserAId);
    }


    @Test
    public void testRemindSuit(){

        // 用户A订阅ProductA的被喜欢的事件
        msgNotifyService.subscribe(UserAId , ProductAId ,"product","like_product");


        // 用户B评论Product A
        msgNotifyService.createRemind(ProductAId,"product","comment",UserBId,"用户B评论Product A");


        msgNotifyService.pullRemind(UserAId);


    }
}