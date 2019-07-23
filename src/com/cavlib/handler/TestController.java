package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public String test() {
//		PageHelper.startPage(1,5);
//		List<Post> postList = testService.testPost();
//		for (Post post : postList) {
//			System.out.println(post);
//		}
//		testService.testPost();
		testService.testImage();
		return "test";
	}
}
