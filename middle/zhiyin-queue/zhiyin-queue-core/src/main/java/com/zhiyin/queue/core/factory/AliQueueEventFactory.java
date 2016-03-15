package com.zhiyin.queue.core.factory;

import com.alibaba.fastjson.JSON;
import com.zhiyin.queue.core.event.AliQueueEvent;
import com.zhiyin.queue.core.type.TopicType;
import com.zhiyin.event.core.EventEntity;

/**
 * Created by wangqinghui on 2016/3/15.
 */
public class AliQueueEventFactory {

    /**
     * Ali队列
     * @return
     */
    public static AliQueueEvent gen(String topic, EventEntity event){

        AliQueueEvent msg = new AliQueueEvent();

        msg.setBodyStr(JSON.toJSONString(event) );
        msg.setTag("test");

        msg.setTopic( topic );


        return msg;
    }


    public static AliQueueEvent genTestTopic( EventEntity event){

        AliQueueEvent msg = new AliQueueEvent();

        msg.setBodyStr(JSON.toJSONString(event) );
        msg.setTag("test");

        msg.setTopic( TopicType.HGTEST.getName() );


        return msg;
    }




}
