package de.mirkosertic.service;

import de.mirkosertic.domain.Message;
import de.mirkosertic.domain.MessageAcknowledgement;

/**
 * Created by wangqinghui on 2016/1/21.
 */
public interface MessageHandlerService {
    public MessageAcknowledgement handleMessage(Message message) ;
    }
