package com.hg.msg.mapper;

import com.hg.msg.entity.MsgSaveRemind;

public interface MsgSaveRemindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgSaveRemind record);

    int insertSelective(MsgSaveRemind record);

    MsgSaveRemind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgSaveRemind record);

    int updateByPrimaryKey(MsgSaveRemind record);
}