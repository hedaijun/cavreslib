package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.Post;
import com.cavlib.beans.User;
import com.cavlib.service.DisplayPostsService;

@Controller
public class GetMyPosts {
	
	@Autowired
	private DisplayPostsService displayPostsService;
	
	@RequestMapping("/getMyPosts")
	public String getPosts(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		List<Post> posts = displayPostsService.loadMyPosts(((User)session.getAttribute("user")).getUserId());
		Map<Integer,String> imgs=displayPostsService.loadImgs(posts);
		request.setAttribute("posts", posts);
		return "myPosts";
	}
	
}
