package com.hg.msg.controller;

import com.hg.msg.service.IMsgNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

	@Autowired
	private IMsgNotifyService msgNotifyService;

	@RequestMapping("/testok")
	@ResponseBody
	public String hello(){
		msgNotifyService.getUserNotify(1L);
		return "hello";
	}

}
