package com.hg.queue.api.event.controller;


import com.hg.queue.config.SystemConfig;
import com.hg.queue.core.EventMessage;
import com.hg.queue.core.event.TopicType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/queue")
//@Slf4j
public class QueueProducerController {

    final static Logger log = LoggerFactory.getLogger(QueueProducerController.class);


    @RequestMapping(method = RequestMethod.GET, path = "/test" )
    public String test() {
        String str =  UUID.randomUUID().toString();
        try {

            EventMessage msg = new EventMessage();

            msg.setBodyStr(UUID.randomUUID().toString());
            msg.setTag("test");

            msg.setTopic(TopicType.HGTEST.getName());

            SystemConfig.ProduceAliTestQueueEvent.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return str;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/put/event", produces = "application/json")
    public String put(@RequestBody EventMessage event) {


        if( TopicType.HGTEST.getName().equals(event.getTopic()) ){
            try {
                SystemConfig.ProduceAliTestQueueEvent.put(event);
            } catch (InterruptedException e) {
                log.error("put msg error. ");
            }
        }

        return "success";
    }
}
