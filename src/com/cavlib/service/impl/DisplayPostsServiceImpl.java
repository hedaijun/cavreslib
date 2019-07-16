package com.cavlib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Post;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.DisplayPostsService;

@Service
public class DisplayPostsServiceImpl implements DisplayPostsService {
	
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public List<Post> loadPage(int page,String tag, String keyWord) {
		// TODO Auto-generated method stub
		return postMapper.getFivePost(page, keyWord, tag);
		
	}
	
}
