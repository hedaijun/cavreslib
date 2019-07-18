package com.cavlib.dao;

import org.apache.ibatis.annotations.Param;

import com.cavlib.beans.User;

public interface UserMapper {
    
	public Integer checkUserByUserName(String name);
	public String getPasswordByUserName(String name);
	public User getUserInfoByUserName(String name);
	public Boolean setIsBaned(@Param("is_baned") Boolean is_baned, @Param("name") String name);
	public Boolean addUser(@Param("name") String name, @Param("password")String password);
	
}
