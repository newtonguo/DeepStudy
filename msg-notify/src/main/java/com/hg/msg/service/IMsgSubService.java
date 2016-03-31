package com.hg.msg.service;

/**
 * Created by wangqinghui on 2016/3/22.
 */
public interface IMsgSubService {
    Long insertSelective(Long target, String targetType, String action, Long userId);
}
