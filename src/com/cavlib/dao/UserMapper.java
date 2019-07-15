package com.cavlib.dao;

import com.cavlib.beans.User;

public interface UserMapper {
    
	public Boolean checkUserByUserName(String name);
	public String getPasswordByUserName(String name);
	public User getUserInfoByUserName(String name);
	public Boolean setIsBaned(Boolean isBaned);
	public Boolean addUser(User user);
	
}
