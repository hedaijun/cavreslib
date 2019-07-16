package com.cavlib.service;

import com.cavlib.beans.User;

public interface LoginService {
	int login(String username,String password);
	User getUser(String username);
}
