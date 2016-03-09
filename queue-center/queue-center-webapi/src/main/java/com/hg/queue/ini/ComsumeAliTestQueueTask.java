package com.hg.queue.ini;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.*;
import com.hg.queue.config.QueueConfig;
import com.hg.queue.config.SystemConfig;
import com.hg.queue.core.EventMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangqinghui on 2016/3/9.
 */
//@Slf4j
public class ComsumeAliTestQueueTask extends Thread {

    final static Logger log = LoggerFactory.getLogger(ComsumeAliTestQueueTask.class);



    public ComsumeAliTestQueueTask(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (true ) {

            try {
                EventMessage msg = SystemConfig.ConsumeAliTestQueueEvent.take();
                log.info("process message:{}",JSON.toJSONString(msg));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
