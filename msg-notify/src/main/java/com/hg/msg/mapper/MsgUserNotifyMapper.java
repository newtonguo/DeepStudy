package com.hg.msg.mapper;

import com.hg.msg.entity.MsgUserNotify;

import java.util.Date;
import java.util.List;

public interface MsgUserNotifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgUserNotify record);

    int insertSelective(MsgUserNotify record);

    MsgUserNotify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgUserNotify record);

    int updateByPrimaryKey(MsgUserNotify record);

    MsgUserNotify selectLatestNotify(Long userId, int announce);

    List<MsgUserNotify> selectUserNewNotify(Long userId, Date updateDate, int announce);
}