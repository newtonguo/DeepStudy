package com.zhiyin.hystrix.module.annodemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.zhiyin.hystrix.module.annodemo.httpservice.MessageHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class RemoteMessageAnnotationClient  {
 
//    private final RemoteServiceClient remoteServiceClient;

    @Autowired
    private MessageHandlerService remoteServiceClient;


 
    @HystrixCommand(groupKey= "Annotation", fallbackMethod = "defaultMessage", commandKey = "RemoteMessageAnnotationClient" )
    public MessageAcknowledgement sendMessage(Message message) {
        return this.remoteServiceClient.handleMessage(message);
    }
 
    public MessageAcknowledgement defaultMessage(Message message) {
        return new MessageAcknowledgement("-1", message.getPayload(), "Fallback Payload");
    }
 
}