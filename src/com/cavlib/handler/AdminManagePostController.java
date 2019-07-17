package com.cavlib.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.service.AdminManagePostService;
import com.cavlib.service.PostContentService;

@Controller
public class AdminManagePostController {
	@Autowired
	private AdminManagePostService adminManagePostService;
	
	@RequestMapping("/deletePosts")
	public String deleteUser(HttpServletRequest request,HttpServletResponse reponse) {
		String []deletePost_id = request.getParameterValues("post_id");
		for (int i =0;i<deletePost_id.length;i++) {
			adminManagePostService.deletePost(Integer.parseInt(deletePost_id[i]));
		}
		request.setAttribute("result","success");
		return "forward:/getUsers";
	}
}
