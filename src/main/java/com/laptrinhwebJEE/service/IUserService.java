package com.laptrinhwebJEE.service;

import com.laptrinhwebJEE.model.User;

public interface IUserService {
	User findUserLogin(User user);
	String registerUser(User user);
}
