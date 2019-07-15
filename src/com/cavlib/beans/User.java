package com.cavlib.beans;

import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = 8363556599610850348L;
	
	private Integer id;
	private String name;
	private String password;
	private Boolean isManager;
	private Boolean isBaned;
	public User() {
		
	}

	public User(Integer id, String name, String password,Boolean isManager,Boolean isBaned) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.isManager = isManager;
		this.isBaned = isBaned;
	}

	public int getId() {
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
	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public Boolean getIsBaned() {
		return isBaned;
	}

	public void setIsBaned(Boolean isBaned) {
		this.isBaned = isBaned;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", isManager="  +isManager+", isBanded="+isBaned+ "]";
	}
}