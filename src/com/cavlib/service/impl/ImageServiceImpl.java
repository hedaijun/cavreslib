package com.cavlib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Image;
import com.cavlib.dao.ImageMapper;
import com.cavlib.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public void addImage(Image image) {
		imageMapper.addImage(image);
	}
}
