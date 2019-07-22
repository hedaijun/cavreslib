package com.cavlib.service;

import java.util.List;

import com.cavlib.beans.Post;

public interface AdminManagePostService {
	Boolean deletePost(int id);
	public List<Post> loadDeletePage(int page,String tag, String keyWord);
}
