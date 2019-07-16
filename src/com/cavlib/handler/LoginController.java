package com.cavlib.handler;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response) {
		String username=(String)request.getAttribute("inputEmail3");
		String password=(String)request.getAttribute("inputPassword3");
		int id=loginService.login(username, password);
		if(id>=0) {
			response.addCookie(new Cookie("userid",new String("id")));
			response.addCookie(new Cookie("username",username));
			String isManager=loginService.getUser(username).getIsManager()?"true":"false";
			response.addCookie(new Cookie("authority",isManager));
		}
		return "index";
	}
	

}
