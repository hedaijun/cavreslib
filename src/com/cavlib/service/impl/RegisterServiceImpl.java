package com.cavlib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.User;
import com.cavlib.dao.UserMapper;
import com.cavlib.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User register(String username, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.getUserInfoByUserName(username);
		if(user!=null) return null;
		userMapper.addUser(username, password);
		
		return userMapper.getUserInfoByUserName(username);
	}

}
