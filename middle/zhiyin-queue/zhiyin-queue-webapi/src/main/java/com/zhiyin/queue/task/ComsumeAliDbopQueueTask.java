package com.zhiyin.queue.task;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sun.tools.internal.ws.processor.model.Response;
import com.zhiyin.event.core.EventEntity;
import com.zhiyin.event.core.body.binlog.BinlogEventBody;
import com.zhiyin.event.core.body.binlog.BinlogOpType;
import com.zhiyin.http.factory.HttpRequestFactory;
import com.zhiyin.http.factory.HttpUrlFactory;
import com.zhiyin.queue.config.SystemConfig;
import com.zhiyin.queue.core.event.AliQueueEvent;
import com.zhiyin.queue.core.factory.AliQueueEventFactory;
import com.zhiyin.utils.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Request;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 消费Ali队列消息
 * Created by wangqinghui on 2016/3/9.
 */
@Slf4j
public class ComsumeAliDbopQueueTask extends Thread {

    public static final String ServiceUrl = "";

    public ComsumeAliDbopQueueTask(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (true) {

            try {
                AliQueueEvent msg = SystemConfig.ConsumeAliDbopQueueEvent.take();


                EventEntity event = AliQueueEventFactory.reDbopEvent(msg);

                BinlogEventBody body = (BinlogEventBody) event.getBody();
                BinlogOpType opType = body.getOpType();

                // 构建索引
                if (BinlogOpType.UPDATE.equals(opType)) {
                    Long id = body.getDataId();

                    Map<String, Long> val = Maps.newHashMap();
                    val.put("id", id);
                    try {
                        HttpRequestFactory.post(HttpUrlFactory.get("contents.search.addOrUpdateByIdById"), val);
                    } catch (Exception e) {
                        log.error("build searcher index error", e);
                    }

                }


                TimeUnit.SECONDS.sleep(10);

            } catch (InterruptedException e) {
                log.error("comsume ali dbop error.", e);
            }
        }
    }
}
