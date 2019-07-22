package com.cavlib.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavlib.beans.User;
import com.cavlib.service.ManageUserService;

@Controller
public class ManageUserController {
	@Autowired
	private ManageUserService manageUserService;
	
	@RequestMapping("/setbane")
	public String setBane(Boolean is_baned,String name) {
		//System.out.println("ok");
		manageUserService.setbane(is_baned, name);
		return "redirect:getpage";
	}
	@RequestMapping("/getpage")
	public String getUsers(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int page=1;
		if(request.getParameter("userpage")!=null) page= Integer.valueOf(request.getParameter("userpage"));
		if(page<1) page=1;
		session.setAttribute("userpage", page);
		List<User> users = manageUserService.loadPage(page);
		map.put("users", users);
		return "userManager";
	}
	
}
