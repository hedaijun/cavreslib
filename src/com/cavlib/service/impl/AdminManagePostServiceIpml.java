package com.cavlib.service.impl;

import com.cavlib.dao.PostMapper;
import com.cavlib.service.AdminManagePostService;

public class AdminManagePostServiceIpml implements AdminManagePostService{

	private PostMapper postMapper;
	
	@Override
	public Boolean deletePost(int id) {
		// TODO Auto-generated method stub
		return postMapper.deletePost(id);
	}

}
