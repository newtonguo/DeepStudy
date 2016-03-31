package com.hg.msg.service.impl;

import com.hg.msg.config.NotifyType;
import com.hg.msg.entity.MsgNotify;
import com.hg.msg.entity.MsgUserNotify;
import com.hg.msg.mapper.MsgNotifyMapper;
import com.hg.msg.mapper.MsgUserNotifyMapper;
import com.hg.msg.service.IMsgUserNotifyService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangqinghui on 2016/3/31.
 */
@Service
public class MsgUserNotifyServiceImpl implements IMsgUserNotifyService {

    @Autowired
    MsgUserNotifyMapper msgUserNotifyMapper;

    @Autowired
    MsgNotifyMapper msgNotifyMapper;

    @Override
    public Long insertSelective(MsgUserNotify msgUserNotify) {

        msgUserNotify.setId( IdGen.gen() );
        msgUserNotify.setUpdateTime( DateTime.now().toDate() );
        msgUserNotify.setCreateTime(DateTime.now().toDate());
        msgUserNotify.setIsRead(0);

        msgUserNotify.setDelStatus(0);

        // 获取notify type
        MsgNotify notify = msgNotifyMapper.selectByPrimaryKey(msgUserNotify.getNotifyId());
        msgUserNotify.setNotifyType( notify.getType() );

         msgUserNotifyMapper.insertSelective(msgUserNotify);
        return msgUserNotify.getId();
    }

    @Override
    public Long insertSelective(Long userId, Long notifyId) {
        MsgUserNotify msgUserNotify = new MsgUserNotify();
        msgUserNotify.setNotifyId( notifyId );
        msgUserNotify.setUserId(userId);

        return  insertSelective(msgUserNotify);
    }



}
