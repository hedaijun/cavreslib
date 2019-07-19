package com.cavlib.service;

import java.util.List;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;

public interface PostContentService {
	Post getPostContent(String id);
	List<String> getPostImg(String id);
	Boolean deletePost(String id);
}
