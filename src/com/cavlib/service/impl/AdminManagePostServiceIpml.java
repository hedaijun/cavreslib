package com.cavlib.service.impl;

import java.awt.print.Printable;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Post;
import com.cavlib.dao.ImageMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.service.AdminManagePostService;
import com.github.pagehelper.PageHelper;

@Service
public class AdminManagePostServiceIpml implements AdminManagePostService{
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public Boolean deletePost(int id,String path) {
		// TODO Auto-generated method stub
		postMapper.deletePost(id);
		imageMapper.deleteImage(id);
		List<String> array = imageMapper.getImageByPostId(id);
		for(int i=0;i<array.size();i++) {
			File file = new File(path+"/"+array.get(i));
			if(file.exists()&&file.isFile()) {
				file.delete();
			}
		}
		
		return true;
	}
	
	
	@Override
	public List<Post> loadDeletePage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,30);
		return postMapper.getAllDeletePost();
		
		
	}

}
