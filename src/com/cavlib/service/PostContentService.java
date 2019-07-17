package com.cavlib.service;

import com.cavlib.beans.Comment;
import com.cavlib.beans.Post;

public interface PostContentService {
	Post getPostContent(String id);
	Boolean deletePost(String id);
}
