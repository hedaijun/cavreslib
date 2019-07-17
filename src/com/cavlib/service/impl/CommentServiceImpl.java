package com.cavlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cavlib.beans.Comment;
import com.cavlib.dao.CommentMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.CommentService;

public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<Comment> getComment(String postId){
		return commentMapper.getContentByPost(Integer.valueOf(postId));
	}
	
	@Override
	public boolean setComment(Comment comment) {
		return commentMapper.addComment(comment);
	}
}
