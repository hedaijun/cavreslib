package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.Post;
import com.cavlib.service.AdminManagePostService;
import com.cavlib.service.DisplayPostsService;
import com.cavlib.service.PostContentService;

@Controller
public class AdminManagePostController {
	@Autowired
	@Resource
	private AdminManagePostService adminManagePostService;
	@Autowired
	@Resource
	private DisplayPostsService displayPostsService;
	
	@RequestMapping("/deletePosts")
	public String deleteUser(HttpServletRequest request,HttpServletResponse reponse) {
		String []deletePost_id = request.getParameterValues("post_id");
		for (int i =0;i<deletePost_id.length;i++) {
			adminManagePostService.deletePost(Integer.parseInt(deletePost_id[i]));
		}
		return "forward:/getPosts";
	}
	@RequestMapping("/toManager")
	public String toManager() {
		return "Manager";
	}
	
	@RequestMapping("/deleteSingleUser")
	public String deleteSingleUser(HttpServletRequest request,HttpServletResponse reponse) {
		String post_id = request.getParameter("post_id");
		System.out.println(post_id);
//		int post_id = Integer.parseInt();
//		System.out.print(post_id);
		int intpost_id = Integer.parseInt(post_id);
		System.out.println(intpost_id);
		boolean frag = adminManagePostService.deletePost(intpost_id);
		return "forward:/getPosts";
	}
	
	
	@RequestMapping("/getDeletePosts")
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
		List<Post> deletePosts = adminManagePostService.loadDeletePage(page,tag,keyword);
		session.setAttribute("tag", tag);
		session.setAttribute("keyword", keyword);
		session.setAttribute("pageindex", page);
		session.setAttribute("deletePosts", deletePosts);
		return "Manager";
	}
}
