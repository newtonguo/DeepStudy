package com.hg.msg.mapper;

import com.hg.msg.entity.MsgNotify;

import java.util.Date;
import java.util.List;

public interface MsgNotifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgNotify record);

    int insertSelective(MsgNotify record);

    MsgNotify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgNotify record);

    int updateByPrimaryKey(MsgNotify record);

    List<MsgNotify> selectAfterDate(int announce, Date createTime);

    MsgNotify selectSubNotify(MsgNotify msgNotify);
}