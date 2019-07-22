package com.cavlib.service;

import java.util.List;

import com.cavlib.beans.User;

public interface ManageUserService {
	Boolean setbane(Boolean is_baned, String name);
	List<User> loadPage(int page) ;
}
