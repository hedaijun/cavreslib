package com.scau.web.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scau.web.bean.User;
import com.scau.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUsers")
	public String getAllUser(Map<String,Object> map) {
		List<User> users = userService.getAllUser();
		map.put("users", users);
		return "userList";
	}
}

