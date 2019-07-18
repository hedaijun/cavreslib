package com.cavlib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.User;
import com.cavlib.dao.UserMapper;
import com.cavlib.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserMapper userMapper;
	@Override
	public User login(String username, String password) {
		User user =userMapper.getUserInfoByUserName(username);
		if(user!=null&&user.getPassword().equals(password)) return user;
		return null;
	}

}
