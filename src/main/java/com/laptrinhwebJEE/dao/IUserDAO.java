package com.laptrinhwebJEE.dao;

import com.laptrinhwebJEE.model.User;

public interface IUserDAO extends GenericDAO<User>{
	User findUserLogin(User user);
	boolean findUserName(String userName);
	Long save(User user);
}
