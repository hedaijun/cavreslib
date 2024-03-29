package com.cavlib.handler;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.User;
import com.cavlib.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String username=(String)request.getParameter("loginUsername");
		String password=(String)request.getParameter("loginPassword");
		User user=loginService.login(username, password);
		session.setAttribute("user", user);
		request.setAttribute("loginSuccess", user!=null?Boolean.TRUE:null);
		request.setAttribute("loginFail", user==null?Boolean.TRUE:null);
		return "forward:/getPosts";
	}
	

}
