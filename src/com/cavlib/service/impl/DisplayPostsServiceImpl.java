package com.cavlib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Image;
import com.cavlib.beans.Post;
import com.cavlib.dao.ImageMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.DisplayPostsService;
import com.github.pagehelper.PageHelper;

@Service
public class DisplayPostsServiceImpl implements DisplayPostsService {
	
	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public List<Post> loadPosts(int page,String tag, String keyWord) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,8);
		return tag.equals("全部")?postMapper.getFivePost(keyWord, null):postMapper.getFivePost(keyWord, tag);
	}
	
	@Override
	public List<Post> loadMyPosts(int userID) {
		// TODO Auto-generated method stub
		return postMapper.getPostByUserId(userID);
	}
	
	@Override
	public Map<Integer, String> loadImgs(List<Post> posts) {
		// TODO Auto-generated method stub
		Map<Integer,String> imgs= new HashMap();
		for(Post post:posts) {
			List<String> img =imageMapper.getImageByPostId(post.getPostId());
			if(img.size()>0) imgs.put(post.getPostId(), img.get(0));
		}
		return imgs;
	}
	
}
