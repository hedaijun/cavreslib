package com.cavlib.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;
import com.cavlib.dao.CommentMapper;
import com.cavlib.dao.ImageMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.PostContentService;

@Service
public class PostContentServiceIpml implements PostContentService {
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public Post getPostContent(String postId){
		Post postContent;
		postContent = postMapper.getPostById(Integer.valueOf(postId));

		postContent.setTime(new Timestamp(postContent.getTime().getTime()-3600*8*1000));

		return postContent;
	}
	
	@Override
	public Boolean deletePost(String postId) {
		return postMapper.deletePost(Integer.valueOf(postId));
	}
	
	@Override
	public List<String> getPostImg(String postId) {
		List<String> img =imageMapper.getImageByPostId(Integer.valueOf(postId));
		return img;
	}
}
