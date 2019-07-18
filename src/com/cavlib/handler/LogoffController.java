package com.cavlib.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoffController {
	
	@RequestMapping("/logoff")
	public String logoff(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session.removeAttribute("user");
		return "forward:/getPosts";
	}
}
