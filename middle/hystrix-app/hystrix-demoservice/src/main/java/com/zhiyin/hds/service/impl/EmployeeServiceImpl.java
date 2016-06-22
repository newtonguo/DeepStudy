package com.zhiyin.hds.service.impl;

import java.net.URI;

import com.zhiyin.hds.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


	public String list() {
		return "te";
	}

}
