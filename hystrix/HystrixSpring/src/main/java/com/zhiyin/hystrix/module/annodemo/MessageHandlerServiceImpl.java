//package com.zhiyin.hystrix.module.annodemo;
//
//import de.mirkosertic.service.MessageHandlerService;
//import org.springframework.context.annotation.Configuration;
//import rx.Observable;
//
//import java.util.concurrent.TimeUnit;
//
//public class MessageHandlerServiceImpl implements MessageHandlerService {
//
//    @Configuration("reply.message")
//    private String replyMessage;
//
//    public Observable<MessageAcknowledgement> handleMessage(Message message) {
//        logger.info("About to Acknowledge");
//        return Observable.timer(message.getDelayBy(), TimeUnit.MILLISECONDS)
//                .map(l -> message.isThrowException())
//                .map(throwException -> {
//                    if (throwException) {
//                        throw new RuntimeException("Throwing an exception!");
//                    }
//                    return new MessageAcknowledgement(message.getId(), message.getPayload(), replyMessage);
//                });
//    }
//
//
//}