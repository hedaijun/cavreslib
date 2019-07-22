package com.cavlib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Post;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.PublishService;

@Service
public class PublishServiceImpl implements PublishService{
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public void publishPost(Post post) {
		postMapper.publishPost(post);
	}
}
