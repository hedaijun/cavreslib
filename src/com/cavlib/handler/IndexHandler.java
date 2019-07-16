package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cavlib.beans.Post;

@Controller
public class IndexHandler {
	@Autowired
	private postService postService;
	
	@RequestMapping("/")
	public String getPost(Map<String,Object> map,HttpServletRequest request) {
		Integer page= Integer.valueOf(request.getParameter("page"));
		String tag= request.getParameter("tag");
		String keyWord= request.getParameter("keyWord");
		if(page == null) page = 0;
		if(tag == null) tag = "";
		if(keyWord == null) keyWord = "";
		List<Post> posts = postService.getPostByPage(page*5,tag,keyWord);
		map.put("posts", posts);
		return "index";
	}
}
