package com.zhiyin.rpc.shi.demo.action;


import com.zhiyin.rpc.shi.demo.remote.service.DemoService;
import com.zhiyin.rpc.shi.demo.remote.service.TimeConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private TimeConsumeService timeConsumeService;

    @RequestMapping(value = "/rpc", method = RequestMethod.GET)
    public String prc( ) {

        return demoService.getName();
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String time( ) {

        return timeConsumeService.timeConsume();
    }

}