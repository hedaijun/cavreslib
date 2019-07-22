package com.cavlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.User;
import com.cavlib.dao.UserMapper;
import com.cavlib.service.ManageUserService;
import com.github.pagehelper.PageHelper;

@Service
public class ManageUserServiceImpl implements ManageUserService{
	@Autowired
	private UserMapper userMapper;
	
	public Boolean setbane(Boolean is_baned, String name){
		return userMapper.setIsBaned(is_baned, name);
	}
	public List<User> loadPage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,5);//可以通过修改该数值来改变每页的用户数量
		return userMapper.getUsers();
	}
}
