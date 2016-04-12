package com.zhiyin.hystrix.module.annodemo.httpservice;


import com.zhiyin.hystrix.module.annodemo.Message;
import com.zhiyin.hystrix.module.annodemo.MessageAcknowledgement;

/**
 * Created by wangqinghui on 2016/1/21.
 */
public interface MessageHandlerService {
    public MessageAcknowledgement handleMessage(Message message) ;
    }
