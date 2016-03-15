package com.zhiyin.queue.core.factory;

import com.alibaba.fastjson.JSON;
import com.zhiyin.queue.core.event.AliQueueEventMessage;
import com.zhiyin.queue.core.type.TopicType;
import com.zhiyin.event.core.EventEntity;

/**
 * Created by wangqinghui on 2016/3/15.
 */
public class QueueEventGenFactory {

    /**
     * test队列
     * @return
     */
    public static AliQueueEventMessage genTest(String topic, EventEntity event){


        AliQueueEventMessage msg = new AliQueueEventMessage();

        msg.setBodyStr(JSON.toJSONString(event) );
        msg.setTag("test");

        msg.setTopic( topic );


        return msg;
    }
}
