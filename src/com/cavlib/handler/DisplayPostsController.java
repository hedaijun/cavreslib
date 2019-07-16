package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cavlib.beans.Post;
import com.cavlib.service.DisplayPostsService;

@Controller
public class DisplayPostsController {
	@Autowired
	private DisplayPostsService displayPostsService;
	
	@RequestMapping("/")
	public String getPosts(Map<String,Object> map,HttpServletRequest request) {
		Integer page= Integer.valueOf(request.getParameter("page"));
		String tag= request.getParameter("tag");
		String keyWord= request.getParameter("keyWord");
		List<Post> posts = displayPostsService.loadPage(page,tag,keyWord);
		map.put("post", posts);
		return "index";
	}
}
