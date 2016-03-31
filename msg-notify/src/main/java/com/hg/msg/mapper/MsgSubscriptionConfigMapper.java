package com.hg.msg.mapper;

import com.hg.msg.entity.MsgSubscriptionConfig;

public interface MsgSubscriptionConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgSubscriptionConfig record);

    int insertSelective(MsgSubscriptionConfig record);

    MsgSubscriptionConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgSubscriptionConfig record);

    int updateByPrimaryKey(MsgSubscriptionConfig record);

    MsgSubscriptionConfig selectByUid(Long userId);
}