package com.zhiyin.queue.ini;

import com.aliyun.openservices.ons.api.*;
import com.zhiyin.queue.config.QueueConfig;
import com.zhiyin.queue.config.SystemConfig;
import com.zhiyin.queue.core.event.AliQueueEvent;
import com.zhiyin.queue.core.type.ConsumerType;
import com.zhiyin.queue.core.util.BeanMapper;
import com.zhiyin.queue.task.ComsumeAliTestQueueTask;
import com.zhiyin.queue.task.ProduceAliTestQueueTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 系统初始化执行
 */
@Slf4j
@Component
public class SysInitBean implements InitializingBean {


    public void afterPropertiesSet() throws Exception {

        startTestQueueConsumer();

        Thread thread = new ProduceAliTestQueueTask("t1");
        thread.start();
        log.info("处理生成者队列启动成功");

        Thread thread2 = new ComsumeAliTestQueueTask("t2");
        thread2.start();
        log.info("消费者线程启动。");

    }

    /**
     * 测试队列监听，接收消息，并放入本地队列用于接收
     */
    public void startTestQueueConsumer() {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, ConsumerType.HGTEST.getName());
        properties.put(PropertyKeyConst.AccessKey, QueueConfig.acckey);
        properties.put(PropertyKeyConst.SecretKey, QueueConfig.seckey);
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(ConsumerType.HGTEST.getTopic(), "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {

                AliQueueEvent event = BeanMapper.map(message, AliQueueEvent.class);

                try {
                    SystemConfig.ConsumeAliTestQueueEvent.put(event);
                } catch (InterruptedException e) {
                    log.error("get queue error.", e);
                }
                return Action.CommitMessage;
            }
        });
        consumer.start();
        log.info("监听Ali Consumer Test Queue起动。");
    }

}
