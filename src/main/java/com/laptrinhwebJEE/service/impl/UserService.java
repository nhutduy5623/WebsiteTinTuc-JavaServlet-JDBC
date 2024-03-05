package com.laptrinhwebJEE.service.impl;

import javax.inject.Inject;

import com.laptrinhwebJEE.dao.impl.UserDAO;
import com.laptrinhwebJEE.model.User;
import com.laptrinhwebJEE.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	UserDAO userDao;
	
	@Override
	public User findUserLogin(User user) {
		user.setStatus(1);
		return userDao.findUserLogin(user);
	}

	@Override
	public String registerUser(User user) {
		if(!userDao.findUserName(user.getUserName()))
			return userDao.save(user).toString();
		return "User exists!";
	}
	
}
