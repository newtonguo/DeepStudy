package com.zhiyin.event.engine.body.module.test;

import com.zhiyin.event.engine.body.BasicEventBody;

/**
 * 测试用户事件体
 * @author 
 *
 */


public class DemoAddEventBody extends BasicEventBody {
	private Long id;
	private String name;
	private String gender;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	
}
