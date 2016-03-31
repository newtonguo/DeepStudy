package com.hg.msg.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.hg.msg.config.NotifyType;
import com.hg.msg.entity.MsgNotify;
import com.hg.msg.entity.MsgSubscription;
import com.hg.msg.entity.MsgSubscriptionConfig;
import com.hg.msg.entity.MsgUserNotify;
import com.hg.msg.mapper.MsgNotifyMapper;
import com.hg.msg.mapper.MsgSubscriptionConfigMapper;
import com.hg.msg.mapper.MsgSubscriptionMapper;
import com.hg.msg.mapper.MsgUserNotifyMapper;
import com.hg.msg.service.IMsgNotifyService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wangqinghui on 2016/3/22.
 */
@Service
public class MsgNotifyService implements IMsgNotifyService {

    @Autowired
    private MsgNotifyMapper msgNotifyMapper;

    @Autowired
    private MsgUserNotifyMapper msgUserNotifyMapper;

    @Autowired
    private MsgSubscriptionMapper msgSubscriptionMapper;

    @Autowired
    private MsgSubscriptionConfigMapper msgSubscriptionConfigMapper;

    @Override
    public Long createAnnounce(String content, Long sender) {
        MsgNotify msgNotify = new MsgNotify();
        msgNotify.setContent(content);
        msgNotify.setSender(sender);
        msgNotify.setId(DateTime.now().getMillis());

        msgNotifyMapper.insertSelective(msgNotify);

        return msgNotify.getId();
    }

    @Override
    public List<MsgUserNotify> pullAnnounce(Long userId) {

//        List<Msg>

        // 查询最新的公告
        MsgUserNotify latestAnnounce =  msgUserNotifyMapper.selectLatestNotify(userId,NotifyType.Announce);


//        用lastTime作为过滤条件，查询Notify的公告信息
        List<MsgNotify> annList = msgNotifyMapper.selectAfterDate( NotifyType.Announce, latestAnnounce.getCreateTime() );

        for(MsgNotify msgNotify : annList){
            MsgUserNotify msgUserNotify = new MsgUserNotify();
            msgUserNotify.setId( IdGen.gen() );
            msgUserNotify.setNotifyId(msgNotify.getId());
            msgUserNotify.setCreateTime( DateTime.now().toDate() );
            msgUserNotify.setUserId(userId);
        }

        // TODO add return
        return null;
    }

//    @Override
    public List<MsgUserNotify> selectUserNewNotify(Long userId,Date updateDate){

        return msgUserNotifyMapper.selectUserNewNotify(userId,updateDate,NotifyType.Announce);

    }


    @Override
    public Long create(String content, Long sender) {
        return null;
    }

    @Override
    public MsgNotify createRemind(Long target, String targetType, String action, Long sender, String content) {

        MsgNotify msgNotify = new MsgNotify();
        msgNotify.setId( IdGen.gen() );
        msgNotify.setType( NotifyType.Remind );
        msgNotify.setTarget( target );
        msgNotify.setTargetType( targetType );
        msgNotify.setAction( action );
        msgNotify.setSender( sender );
        msgNotify.setContent(content);
        return msgNotify;
    }

    @Override
    public Long createMessage(String content, Long sender, Long receiver) {

        MsgNotify notify = new MsgNotify();
        notify.setId(IdGen.gen());
        notify.setContent(content);
        notify.setSender(sender);
        notify.setTarget( receiver  );

        notify.setTargetType("3");

        msgNotifyMapper.insertSelective(notify);


        MsgUserNotify userNotify = new MsgUserNotify();
        userNotify.setId( IdGen.gen() );
        userNotify.setCreateTime(DateTime.now().toDate());
        userNotify.setUpdateTime(DateTime.now().toDate());
        userNotify.setUserId(sender);
        userNotify.setNotifyId(notify.getId() );
        userNotify.setIsRead(0);
        msgUserNotifyMapper.insertSelective(userNotify);

        return userNotify.getId() ;
    }

    @Override
    public Long pullRemind(Long userId) {

//        查询用户的订阅表，得到用户的一系列订阅记录
        List<MsgSubscription> subList = msgSubscriptionMapper.selectByUserId(userId);

//        通过每一条的订阅记录的target、targetType、action、createdAt去查询Notify表，获取订阅的Notify记录。（注意订阅时间必须早于提醒创建时间）
        List<MsgNotify> notifyList = Lists.newArrayList();
        for(MsgSubscription sub : subList){
            MsgNotify notify = selectSubNotifyAfter(sub.getTarget(), sub.getTargetType(), sub.getAction(), sub.getCreateTime());
            if(notify != null){
                notifyList.add(notify);
            }
        }



//        查询用户的配置文件SubscriptionConfig，如果没有则使用默认的配置DefaultSubscriptionConfig
        List<String> actionList = getSubscriptionConfig(userId);


//        使用订阅配置，过滤查询出来的Notify
        List<MsgNotify> filtedNotify = Lists.newArrayList();
        for(MsgNotify notify : notifyList){
            for(String action : actionList){
                if( action.equals(notify.getAction()) ){
                    filtedNotify.add(notify);
                }
            }
        }


//                使用过滤好的Notify作为关联新建UserNotify
        for(MsgNotify notify : filtedNotify){
            MsgUserNotify tmp = new MsgUserNotify();
            tmp.setId(IdGen.gen());
            tmp.setNotifyId(notify.getId());
            tmp.setUserId(userId);
            tmp.setIsRead(0);
            tmp.setCreateTime(DateTime.now().toDate());
            tmp.setUpdateTime(DateTime.now().toDate());

            msgUserNotifyMapper.insertSelective(tmp);
        }

        return null;
    }

    public MsgNotify selectSubNotifyAfter(Long target,String targetType,String action,Date createTime){
        MsgNotify msgNotify = new MsgNotify();
        msgNotify.setTarget(target);
        msgNotify.setTargetType(targetType);
        msgNotify.setAction(action);
        msgNotify.setCreateTime(createTime);


        return msgNotifyMapper.selectSubNotify(msgNotify);
    }

    @Override
    public void subscribe(Long userId, Long targetId,String targetType,String reason){

        MsgNotify msgNotify = new MsgNotify();
        msgNotify.setId( IdGen.gen() );
        msgNotify.setContent(reason);
        msgNotify.setSender(userId);
        msgNotify.setTarget(targetId ) ;
        msgNotify.setTargetType(targetType);
        msgNotifyMapper.insertSelective(msgNotify);


    }

    @Override
    public void cancelSubscription(Long userId, Long target, String targetType) {

        MsgSubscription sub = new MsgSubscription();
        sub.setUserId(userId);
        sub.setTarget(target);
        sub.setTargetType(targetType);

//        msgSubscriptionMapper.deleteByPrimaryKey()
    }
//
@Override
public MsgSubscriptionConfig getSubConfig(Long userId) {

    MsgSubscriptionConfig sel = msgSubscriptionConfigMapper.selectByUid(userId);

    if(sel == null || Strings.isNullOrEmpty(sel.getAction())){
        sel = NotifyUtil.defaultSubConfig();
    }

return sel;
}

    @Override
    public List<String> getSubscriptionConfig(Long userId) {

        MsgSubscriptionConfig sel = msgSubscriptionConfigMapper.selectByUid(userId);

        if(sel == null || Strings.isNullOrEmpty(sel.getAction())){
            sel = NotifyUtil.defaultSubConfig();
        }

        return NotifyUtil.getSubAction(sel.getAction());

    }

    @Override
    public Integer updateSubscriptionConfig(Long userID) {
        return null;
    }

    @Override
    public List<MsgNotify> getUserNotify(Long uid) {
        return null;
    }

//    @Override
//    public List<MsgNotify> getUserNotify(Long uid) {
//        return msgUserNotifyMapper
//    }

    @Override
    public Integer read(Long uid, Long notifyId) {
        return 0;
    }
}
