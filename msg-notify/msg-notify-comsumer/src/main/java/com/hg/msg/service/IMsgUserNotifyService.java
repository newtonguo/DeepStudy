package com.hg.msg.service;

import com.hg.msg.entity.MsgUserNotify;

import java.util.Date;

/**
 * Created by wangqinghui on 2016/3/22.
 */
public interface IMsgUserNotifyService {

    public Long insertSelective(MsgUserNotify msgUserNotify);

    Long insertSelective(Long userId, Long notifyId , Date notifyTime) ;
}
