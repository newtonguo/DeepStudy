package com.hg.queue.config;

import com.aliyun.openservices.ons.api.Message;
import com.hg.queue.core.EventMessage;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wangqinghui on 2016/3/9.
 */
public class SystemConfig {

    public static BlockingDeque<String> EventQueue = new LinkedBlockingDeque<>();

    public static BlockingDeque<EventMessage> ProduceAliTestQueueEvent = new LinkedBlockingDeque<>();
    public static BlockingDeque<EventMessage> ConsumeAliTestQueueEvent = new LinkedBlockingDeque<>();


}
