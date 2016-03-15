package com.zhiyin.queue.core.factory;

import com.alibaba.fastjson.JSON;
import com.zhiyin.queue.core.event.AliQueueEventMessage;
import com.zhiyin.event.core.EventEntity;
import com.zhiyin.event.core.factory.BinlogEventFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by wangqinghui on 2016/3/15.
 */
@Slf4j
public class QueueEventGenFactoryTest {

    @Test
    public void testGenTest() throws Exception {

        EventEntity event = BinlogEventFactory.contentAddd(1L);

        AliQueueEventMessage queue = QueueEventGenFactory.genTest("topic", event);

        log.info(JSON.toJSONString(queue));


    }
}