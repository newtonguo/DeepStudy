package com.zhiyin.event.engine.body.content;

import com.zhiyin.event.engine.body.BasicEventBody;

public class ContentAddBody extends BasicEventBody{
	
	private long id;
	private String title;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
