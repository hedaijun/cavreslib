package com.cavlib.dao;

import java.util.List;

import javax.sound.sampled.LineListener;

import com.cavlib.beans.Comment;

public interface CommentMapper {

	public Boolean addComment(Comment comment);
	public List<Comment> getContentByPost(int post_id);
	public List<Comment> getContentByUser(int user_id);
	public List<Comment> getFiveComment(int post_id, int begin);
}
