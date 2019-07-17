package com.cavlib.service;

import java.util.List;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;
import com.cavlib.beans.User;



public interface CommentService {
	List<Comment> getComment(String postId);
	boolean setComment(Comment comment);
}
