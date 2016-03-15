package com.hg.queue.ini;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.*;
import com.hg.queue.config.QueueConfig;
import com.hg.queue.config.SystemConfig;
import com.hg.queue.core.EventMessage;
import com.hg.queue.core.event.ProducerType;
import com.hg.queue.core.util.BeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangqinghui on 2016/3/9.
 */
//@Slf4j
public class ProduceAliTestQueueTask extends Thread {

    final static Logger log = LoggerFactory.getLogger(ProduceAliTestQueueTask.class);

    public ProduceAliTestQueueTask(String name) {
        super(name);
    }

    @Override
    public void run() {

        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ProducerId, ProducerType.HGTEST.getName() );
        properties.put(PropertyKeyConst.AccessKey, QueueConfig.acckey);
        properties.put(PropertyKeyConst.SecretKey, QueueConfig.seckey);
        Producer producer = ONSFactory.createProducer(properties);

        //在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
        producer.start();

        while ( true ) {

            try {
                EventMessage event = SystemConfig.ProduceAliTestQueueEvent.take();

                Message message = BeanMapper.map(event, Message.class);
                message.setBody(event.getBodyStr().getBytes());
                message.setKey(DateTime.now().getMillis() + "");

                //发送消息，只要不抛异常就是成功
                SendResult sendResult = producer.send(message);
                log.info("send event:{}, send result:{}",JSON.toJSONString(message),sendResult);
            } catch (InterruptedException e) {
                log.error("send message error.",e);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                log.error("sleep thread error.",e);
            }
        }

    }


}
