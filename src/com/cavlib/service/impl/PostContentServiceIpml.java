package com.cavlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;
import com.cavlib.dao.CommentMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.PostContentService;

public class PostContentServiceIpml implements PostContentService {
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public Post getPostContent(String postId){
		return postMapper.getPostById(Integer.valueOf(postId));
	}
	
	@Override
	public Boolean deletePost(String postId) {
		return postMapper.deletePost(Integer.valueOf(postId));
	}
}
