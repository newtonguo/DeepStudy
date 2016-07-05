package com.hg.spring.cache.rediscache.service;

import com.hg.spring.cache.rediscache.entity.User;

import java.util.List;

/**
 * Created by wangqinghui on 2016/7/5.
 */
public interface UserInfoService {

    public List<User> selectAll();
}
