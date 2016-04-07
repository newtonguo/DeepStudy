package com.zhiyin.queue.core.factory;

import com.alibaba.fastjson.JSON;
import com.zhiyin.event.core.EventEntity;
import com.zhiyin.event.core.body.binlog.BinlogEventBody;
import com.zhiyin.event.core.factory.BinlogEventFactory;
import com.zhiyin.queue.core.event.AliQueueEvent;
import com.zhiyin.queue.core.type.TopicType;
import com.zhiyin.utils.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by wangqinghui on 2016/3/15.
 */
@Slf4j
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


    /**
     * 数据库操作队列事件
     * @param event
     * @return
     */
    public static AliQueueEvent genDbOpEvent( EventEntity event){

        AliQueueEvent msg = new AliQueueEvent();

        msg.setBodyStr(JSON.toJSONString(event) );
        msg.setTag("dbop");

        msg.setTopic( TopicType.DBOP.getName() );

        log.info("ali queue event body:{}",msg.getBodyStr());

        return msg;
    }


    /**
     * 解析数据库操作事件
     * @param queue
     * @return
     */
    public static EventEntity reDbopEvent(AliQueueEvent queue){

        if(  TopicType.DBOP.getName().equals( queue.getTopic() ) ){
            String str = queue.getBodyStr();
            log.info("rec event:" + str);
            EventEntity event = JSONUtil.parseJson(str, EventEntity.class);
            if(event == null){
                log.error("get ali event is null, {}", JSONUtil.toJson(queue));
                throw new RuntimeException("event is null.");
            }
//            JSONUtil.parseJsonList( event.getBody(), BinlogEventBody.class );

            return event;
        }

        log.error("reDbopEvent error.");
        return null;
    }

    
    public static void main(String[] args){
        BinlogEventBody body = new BinlogEventBody();
        body.setDbName("zhiyin");
        EventEntity event = BinlogEventFactory.binglog(body);
        AliQueueEvent ali = genDbOpEvent(event);

        String eventStr = JSONUtil.toJson(event);
        log.info(eventStr);

        EventEntity parseEvent = JSONUtil.parseJson(eventStr, EventEntity.class);
        log.info( JSONUtil.toJson(parseEvent.getBody()));
        
  }
}
