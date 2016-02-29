package com.hg.spring.cache.rediscache.entity;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer id;
	public String name;
	public String password;

	
	public String random;
	



	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// 这个需要，不然在实体绑定的时候出错
	public User(){}
	
	public User(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
}
