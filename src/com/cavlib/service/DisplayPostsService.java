package com.cavlib.service;

import java.util.List;
import java.util.Map;

import com.cavlib.beans.Post;

public interface DisplayPostsService {

	List<Post> loadPage(int page,String tag, String keyWord);

}
