package com.witown.open.demo.service.impl;

import org.springframework.stereotype.Service;

import com.witown.open.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Override
	public String getName() {
		return "bob dylan";
	}

}
