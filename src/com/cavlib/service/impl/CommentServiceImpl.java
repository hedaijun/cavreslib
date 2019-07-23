package com.cavlib.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Comment;
import com.cavlib.dao.CommentMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<Comment> getComment(String postId){
		List<Comment> comments;
		comments = commentMapper.getContentByPost(Integer.valueOf(postId));
		for(Comment comment: comments) {
			comment.setTime(new Timestamp(comment.getTime().getTime()-3600*8*1000));
		}
		return comments;
	}
	
	@Override
	public boolean setComment(Comment comment) {
		return commentMapper.addComment(comment);
	}
}
