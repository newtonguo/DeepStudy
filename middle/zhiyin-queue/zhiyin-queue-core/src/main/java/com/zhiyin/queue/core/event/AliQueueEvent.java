package com.zhiyin.queue.core.event;

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
    private String bodyStr;


}