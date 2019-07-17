package com.cavlib.service.impl;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavlib.beans.Post;
import com.cavlib.beans.User;
import com.cavlib.dao.CommentMapper;
import com.cavlib.dao.ImageMapper;
import com.cavlib.dao.PostMapper;
import com.cavlib.dao.UserMapper;
import com.cavlib.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public List<Post> testPost() {
//		Post post = new Post();
//		post.setContent("suhfiuhewinvienwanignawgnegoerjioberuhbiahegheruihge");
//		post.setTitle("张三的生活");
//		post.setUser_id(24);
//		post.setLink("www.baidu.com");
//		post.setType("生活");
//		for (int i = 0; i < 40; i++) {
//			postMapper.publishPost(post);
//			try
//			{
//			Thread.sleep(1000);
//			}
//			catch (Exception e) {
//			}
//		}
		return postMapper.getFivePost("woshsuhf",null);
	}
	
	@Override
    public void testUser() {
		User user = new User();
//		user.setName("张三");
//		user.setPassword("123456");
//		user.setIsManager(false);
//		user.setIsBaned(false);
//		for (int i = 0; i < 20; i++) {
//			user.setName("张三"+i);
//			userMapper.addUser(user);
//		}
//		userMapper.checkUserByUserName("张三");
//		System.out.println(userMapper.getPasswordByUserName("张三"));
		System.out.println(userMapper.getUserInfoByUserName("张三"));
//		userMapper.setIsBaned(true, "张三");
    }
    
	@Override
    public void testComment() {
    	
    }
    
	@Override
    public void testImage() {
    	
    }
}
