package com.zhiyin.rpc.shi.demo.service.impl;

import com.zhiyin.rpc.shi.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getName() {
        log.info("call");
        return "bob dylan";
    }

}
