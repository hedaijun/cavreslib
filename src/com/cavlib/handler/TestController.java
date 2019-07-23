package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.Post;
import com.cavlib.service.DisplayPostsService;
import com.cavlib.service.TestService;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.protocol.a.TextResultsetReader;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,HttpServletResponse reponse) {
//		PageHelper.startPage(1,5);
//		List<Post> postList = testService.testPost();
//		for (Post post : postList) {
//			System.out.println(post);
//		}
//		testService.testPost();
		String path = request.getSession().getServletContext().getRealPath("static/resources");
		testService.testImage(path);
		return "test";
	}
}
