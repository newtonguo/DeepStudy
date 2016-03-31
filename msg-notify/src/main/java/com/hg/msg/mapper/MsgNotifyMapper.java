package com.hg.msg.mapper;

import com.hg.msg.entity.MsgNotify;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MsgNotifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgNotify record);

    int insertSelective(MsgNotify record);

    MsgNotify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgNotify record);

    int updateByPrimaryKey(MsgNotify record);

    List<MsgNotify> selectNewByType(@Param("type") Integer type, @Param("createTime") Date createTime);

//    MsgNotify selectSubNotify(MsgNotify msgNotify);


    List<MsgNotify>  selectSubNotifyAfter(@Param("target") Long target, @Param("targetType") String targetType, @Param("action") String action, @Param("createTime") Date createTime);
}