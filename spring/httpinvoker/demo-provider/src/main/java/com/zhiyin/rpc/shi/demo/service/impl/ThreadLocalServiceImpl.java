package com.zhiyin.rpc.shi.demo.service.impl;

import com.zhiyin.rpc.shi.demo.filter.CatContextManager;
import com.zy.rpc.shi.demo.remote.service.IThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by hg on 2016/7/21.
 */
@Slf4j
@Service("tlService")
public class ThreadLocalServiceImpl implements IThreadLocalService {

    @Override
    public String testPassParm() {
        CatContextManager.printCatInfo();
        return null;
    }
}
