package com.zhiyin.hystrix.module.annodemo.httpservice;



import com.zhiyin.hystrix.module.annodemo.Message;
import com.zhiyin.hystrix.module.annodemo.MessageAcknowledgement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by wangqinghui on 2016/1/21.
 */

@Service
public class MessageHandlerServiceImpl implements MessageHandlerService {
    private static final Logger logger = LoggerFactory.getLogger(MessageHandlerServiceImpl.class);

//    @Configuration("reply.message")
//    private String replyMessage;


    public MessageAcknowledgement handleMessage(Message message) {
        logger.info("About to Acknowledge");
        try {
            Thread.sleep(message.getDelayBy());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new MessageAcknowledgement(message.getId(), message.getPayload(), UUID.randomUUID().toString());
    }


}
