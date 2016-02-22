package de.mirkosertic.service;

import de.mirkosertic.domain.Message;
import de.mirkosertic.domain.MessageAcknowledgement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
