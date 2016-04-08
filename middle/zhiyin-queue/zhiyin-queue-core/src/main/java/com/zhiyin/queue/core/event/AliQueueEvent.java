package com.zhiyin.queue.core.event;

import com.zhiyin.event.core.EventEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by wangqinghui on 2016/3/9.
 */
@Getter
@Setter
public class AliQueueEvent implements Serializable {
    private static final long serialVersionUID = -1385924226856188094L;
    private String topic;
    private String tag;
    private String key;

    @Setter(AccessLevel.NONE)
    private String bodyStr; // EventEntity的序列化值

    //
    public void setEvent(EventEntity event){
        this.bodyStr = event.serialize();
    }


}