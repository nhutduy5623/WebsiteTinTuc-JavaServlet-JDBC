package com.laptrinhwebJEE.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhwebJEE.dao.IUserDAO;
import com.laptrinhwebJEE.mapper.userMapper;
import com.laptrinhwebJEE.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public User findUserLogin(User user) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user as us");
		sql.append(" INNER JOIN role as rl ON rl.id = us.roleId");
		sql.append(" WHERE userName = ? and passWord = ? and status = ?");
		List<User> listResults = new ArrayList<>();
		listResults = super.query(sql.toString(), new userMapper(), user.getUserName(), user.getPassWord(), user.getStatus());
		return listResults.isEmpty() ? null: listResults.get(0) ;
	}

	@Override
	public boolean findUserName(String userName) {
		String sql = "SELECT * FROM user WHERE userName = '"+userName+"'";
		List<User> listResults = super.query(sql, new userMapper());
		return !listResults.isEmpty();
	}

	@Override
	public Long save(User user) {
		String sql = "INSERT INTO user (userName, passWord, fullName, status, roleId) VALUES (?, ?, ?, ?, ?)";
		return super.save(sql, user.getUserName(), user.getPassWord(), user.getFullName(), user.getStatus(), user.getRole().getId());
	}
	
}
