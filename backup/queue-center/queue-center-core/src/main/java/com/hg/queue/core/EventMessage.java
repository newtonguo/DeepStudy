package com.hg.queue.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Properties;

/**
 * Created by wangqinghui on 2016/3/9.
 */
@Getter
@Setter
public class EventMessage implements Serializable {
    private static final long serialVersionUID = -1385924226856188094L;
    private String topic;
    private String tag;
    private String key;
    private String bodyStr;


}