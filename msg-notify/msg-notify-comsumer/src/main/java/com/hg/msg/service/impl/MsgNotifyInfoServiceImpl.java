package com.hg.msg.service.impl;

import com.hg.msg.entity.MsgNotify;
import com.hg.msg.entity.MsgSubscriptionConfig;
import com.hg.msg.entity.MsgUserNotify;
import com.hg.msg.mapper.MsgNotifyMapper;
import com.hg.msg.mapper.MsgSubscriptionMapper;
import com.hg.msg.service.IMsgNotifyInfoService;
import com.hg.msg.service.IMsgNotifyService;
import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by wangqinghui on 2016/3/22.
 */
public class MsgNotifyInfoServiceImpl implements IMsgNotifyInfoService {


    @Autowired
    MsgNotifyMapper msgNotifyMapper;

    @Override
    public Long insertSelective( MsgNotify msgNotify){

        msgNotify.setId( IdGen.gen() );
        msgNotify.setCreateTime(DateTime.now().toDate());
        msgNotify.setUpdateTime(DateTime.now().toDate());

        msgNotify.setDelStatus(0);

        msgNotifyMapper.insertSelective(msgNotify);

        return msgNotify.getId();
    }

    @Override
    public List<MsgNotify> selectNewByType(Integer type, Date createTime){
        return msgNotifyMapper.selectNewByType(type,createTime);
    }

    @Override
    public List<MsgNotify> selectSubNotifyAfter(Long target, String targetType, String action, Date createTime) {
        return msgNotifyMapper.selectSubNotifyAfter(target,targetType,action,createTime);
    }


}

