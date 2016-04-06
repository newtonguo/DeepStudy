package com.zhiyin.queue.api.producer.controller;


import com.alibaba.fastjson.JSON;
import com.zhiyin.event.core.EventEntity;
import com.zhiyin.event.core.factory.BinlogEventFactory;
import com.zhiyin.queue.config.SystemConfig;
import com.zhiyin.queue.core.event.AliQueueEvent;
import com.zhiyin.queue.core.factory.AliQueueEventFactory;
import com.zhiyin.queue.core.type.TopicType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Ali Queue服务接口
 */
@RestController
@RequestMapping("/aliq")
@Slf4j
public class AliQueueProducerController {

    @RequestMapping(method = RequestMethod.GET, path = "/oktest" )
    public String oktest() {
        return "hello";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/test" )
    public String test() {
        String str =  UUID.randomUUID().toString();
        try {

            EventEntity event = BinlogEventFactory.contentAdd(1L);
            AliQueueEvent msg = AliQueueEventFactory.gen(TopicType.HGTEST.getName(), event);

            SystemConfig.ProduceAliTestQueueEvent.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return str;

    }

    /**
     * Ali事件处理
     * @param event
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/put/event", produces = "application/json")
    public String put(@RequestBody AliQueueEvent event) {


        if( TopicType.HGTEST.getName().equals(event.getTopic()) ){
            try {
                log.debug("rec event:{}", JSON.toJSONString(event));
                SystemConfig.ProduceAliTestQueueEvent.put(event);
            } catch (InterruptedException e) {
                log.error("put msg error. ");
            }
        }

        log.info("put event succ.");

        return "success";
    }
}
