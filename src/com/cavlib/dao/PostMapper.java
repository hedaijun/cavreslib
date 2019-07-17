package com.cavlib.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cavlib.beans.Post;

public interface PostMapper {
	public Post getPostById(int post_id);
	public Post getPostByTitle(String title);
	public List<Post> getPostByTime(Date time);
	public List<Post> getPostByUserId(int user_id);
	public List<Post> getPostByType(String type);
	public List<Post> getFivePost(@Param("content") String content, @Param("type")String type);
	
	public boolean publishPost(@Param("post") Post post);
	
	public boolean deletePost(int post_id);
	
	
	
}
