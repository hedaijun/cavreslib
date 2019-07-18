package com.cavlib.beans;

import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = 8363556599610850348L;
	
	private Integer user_id;
	private String name;
	private String password;
	private Boolean is_manager;
	private Boolean is_baned;
	public User() {
		
	}

	public User(Integer user_id, String name, String password,Boolean is_manager,Boolean is_baned) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.is_manager = is_manager;
		this.is_baned = is_baned;
	}
	
	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
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
	public Boolean getIsManager() {
		return is_manager;
	}

	public void setIsManager(Boolean is_manager) {
		this.is_manager = is_manager;
	}

	public Boolean getIsBaned() {
		return is_baned;
	}

	public void setIsBaned(Boolean is_baned) {
		this.is_baned = is_baned;
	}
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", password=" + password + ", is_manager="  +is_manager+", is_baned="+is_baned+ "]";
	}
}
