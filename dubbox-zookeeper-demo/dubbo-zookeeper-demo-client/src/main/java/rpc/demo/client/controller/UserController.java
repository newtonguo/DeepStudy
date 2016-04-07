package rpc.demo.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;

import rpc.demo.api.UserService;

@Controller
public class UserController {

	@RequestMapping("/")
	@ResponseBody
	public String hello(){
		return this.getUserService().hello("admin");
	}
	
//	@Autowired
	@Reference
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
