package com.cavlib.handler;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.User;
import com.cavlib.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/register")
	public String register(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String username=request.getParameter("registerUsername");
		String password=request.getParameter("registerPassword1");
		User user=registerService.register(username, password);
		session.setAttribute("user", user);
		request.setAttribute("registerSuccess", user!=null?Boolean.TRUE:null);
		request.setAttribute("registerFail", user==null?Boolean.TRUE:null);
		return "forward:/getPosts";
	}
}
