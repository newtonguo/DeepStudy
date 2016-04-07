package com.zhiyin.queue.config;

import com.zhiyin.queue.core.event.AliQueueEvent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wangqinghui on 2016/3/9.
 */
public class SystemConfig {

    public static BlockingDeque<String> EventQueue = new LinkedBlockingDeque<>();

    public static BlockingDeque<AliQueueEvent> ProduceAliTestQueueEvent = new LinkedBlockingDeque<>();
    public static BlockingDeque<AliQueueEvent> ConsumeAliTestQueueEvent = new LinkedBlockingDeque<>();

    public static BlockingDeque<AliQueueEvent> ProduceAliDbopQueueEvent = new LinkedBlockingDeque<>();
    public static BlockingDeque<AliQueueEvent> ConsumeAliDbopQueueEvent = new LinkedBlockingDeque<>();


}
