package com.zhiyin.queue.ini;

import com.alibaba.fastjson.JSON;
import com.zhiyin.queue.config.SystemConfig;
import com.zhiyin.queue.core.event.AliQueueEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangqinghui on 2016/3/9.
 */
@Slf4j
public class ComsumeAliTestQueueTask extends Thread {


    public ComsumeAliTestQueueTask(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (true ) {

            try {
                AliQueueEventMessage msg = SystemConfig.ConsumeAliTestQueueEvent.take();
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
