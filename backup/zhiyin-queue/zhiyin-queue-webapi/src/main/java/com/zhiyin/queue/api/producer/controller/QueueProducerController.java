package com.zhiyin.queue.api.producer.controller;


import com.zhiyin.queue.config.SystemConfig;
import com.zhiyin.queue.core.event.AliQueueEventMessage;
import com.zhiyin.queue.core.type.TopicType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/queue")
@Slf4j
public class QueueProducerController {

//    final static Logger log = LoggerFactory.getLogger(QueueProducerController.class);


    @RequestMapping(method = RequestMethod.GET, path = "/test" )
    public String test() {
        String str =  UUID.randomUUID().toString();
//        try {
//
//            SystemConfig.ProduceAliTestQueueEvent.put(msg);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return str;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/put/event", produces = "application/json")
    public String put(@RequestBody AliQueueEventMessage event) {


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
