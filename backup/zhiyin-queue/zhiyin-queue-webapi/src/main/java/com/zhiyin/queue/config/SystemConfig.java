package com.zhiyin.queue.config;

import com.zhiyin.queue.core.event.AliQueueEventMessage;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wangqinghui on 2016/3/9.
 */
public class SystemConfig {

    public static BlockingDeque<String> EventQueue = new LinkedBlockingDeque<>();

    public static BlockingDeque<AliQueueEventMessage> ProduceAliTestQueueEvent = new LinkedBlockingDeque<>();
    public static BlockingDeque<AliQueueEventMessage> ConsumeAliTestQueueEvent = new LinkedBlockingDeque<>();


}
