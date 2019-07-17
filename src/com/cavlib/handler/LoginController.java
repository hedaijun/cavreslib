package com.cavlib.handler;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String username=(String)request.getParameter("inputEmail3");
		String password=(String)request.getParameter("inputPassword3");
		int id=loginService.login(username, password);
		if(id>=0) {
			session.setAttribute("user", loginService.getUser(username));
		}
		return "forward:/getPosts";
	}
	

}
