package com.cavlib.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cavlib.beans.Post;

public interface PostMapper {
	public Post getPostById(int id);
	public Post getPostByTitle(String title);
	public List<Post> getPostByTime(Date time);
	public List<Post> getPostByUserId(int userId);
	
	public boolean publishPost(@Param("post") Post post);
	
	public boolean deletePost(int id);
	
	
	
}
