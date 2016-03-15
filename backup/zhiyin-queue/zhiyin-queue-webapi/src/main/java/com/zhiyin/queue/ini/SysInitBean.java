package com.zhiyin.queue.ini;

import com.aliyun.openservices.ons.api.*;
import com.zhiyin.queue.config.QueueConfig;
import com.zhiyin.queue.config.SystemConfig;
import com.hg.queue.core.event.AliEventMessage;
import com.zhiyin.queue.core.type.ConsumerType;
import com.zhiyin.queue.core.util.BeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 系统初始化执行
 */
//@Slf4j
@Component
public class SysInitBean implements InitializingBean {

    final static Logger log = LoggerFactory.getLogger(ProduceAliTestQueueTask.class);


    public void afterPropertiesSet() throws Exception {

        startTestQueueConsumer();

      Thread thread = new ProduceAliTestQueueTask("t1");
      thread.start();

      System.out.println("thread start. ");
      Thread thread2 = new ComsumeAliTestQueueTask("t2");
      thread2.start();


  }

    /**
     * 测试队列监听
     */
    public void startTestQueueConsumer(){
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, ConsumerType.HGTEST.getName());
        properties.put(PropertyKeyConst.AccessKey,  QueueConfig.acckey);
        properties.put(PropertyKeyConst.SecretKey,  QueueConfig.seckey);
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(ConsumerType.HGTEST.getTopic(), "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {

                AliEventMessage event = BeanMapper.map(message, AliEventMessage.class);

                try {
                    SystemConfig.ConsumeAliTestQueueEvent.put(event);
                } catch (InterruptedException e) {
                    log.error("get queue error.",e);
                }
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }

}
