package com.cavlib.service;

import com.cavlib.beans.User;

public interface LoginService {
	User login(String username,String password);
}
