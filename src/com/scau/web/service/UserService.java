package com.scau.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scau.web.bean.User;
import com.scau.web.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAllUser(){  
		System.out.println();
		return userMapper.getUsers();
	}
}

