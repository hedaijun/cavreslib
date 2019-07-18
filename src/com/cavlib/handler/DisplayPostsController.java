package com.cavlib.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String defaultPage(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		return "forward:/getPosts";
	}
	
	@RequestMapping("/getPosts")
	public String getPosts(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if(session.getAttribute("tag")==null) session.setAttribute("tag", "全部");
		int page=1;
		if(request.getParameter("pageindex")!=null) page= Integer.valueOf(request.getParameter("pageindex"));
		if(page<1) page=1;
		String tag= (String)session.getAttribute("tag");
		String keyword= (String)session.getAttribute("keyword");
		if(request.getParameter("tag")!=null) tag=request.getParameter("tag");
		if(request.getParameter("keyword")!=null) keyword=request.getParameter("keyword");
		if(request.getParameter("back")!=null) {
			tag="全部";
			keyword=null;
			page=1;
		}
		List<Post> posts = displayPostsService.loadPage(page,tag,keyword);
		session.setAttribute("tag", tag);
		session.setAttribute("keyword", keyword);
		session.setAttribute("pageindex", page);
		session.setAttribute("posts", posts);
		return "index";
	}
	
} 
