package com.hg.msg.mapper;

import com.hg.msg.entity.MsgNotify;

public interface MsgNotifyMapper {
    int insert(MsgNotify record);

    int insertSelective(MsgNotify record);
}