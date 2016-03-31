package com.hg.msg.mapper;

import com.hg.msg.entity.MsgSubscription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgSubscriptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgSubscription record);

    int insertSelective(MsgSubscription record);

    MsgSubscription selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgSubscription record);

    int updateByPrimaryKey(MsgSubscription record);

    List<MsgSubscription> selectByUserId(@Param("userId") Long userId);
}