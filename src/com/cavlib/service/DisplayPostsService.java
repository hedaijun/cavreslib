package com.cavlib.service;

import java.util.List;
import java.util.Map;

import com.cavlib.beans.Post;

public interface DisplayPostsService {

	List<Post> loadPosts(int page,String tag, String keyWord);
	List<Post> loadMyPosts(int userID);
	Map<Integer,String> loadImgs(List<Post> posts);
}
