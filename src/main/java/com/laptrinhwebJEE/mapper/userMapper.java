package com.laptrinhwebJEE.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebJEE.model.Role;
import com.laptrinhwebJEE.model.User;

public class userMapper  implements IRowMapper<User>{

	@SuppressWarnings("unchecked")
	@Override
	public User mapperRow(ResultSet rS) {
		User user = new User();
		try {
			user.setFullName(rS.getString("fullName"));
			user.setUserName(rS.getString("userName"));
			user.setPassWord(rS.getString("passWord"));
			user.setId(rS.getLong("id"));
			user.setStatus(rS.getInt("status"));
			Role role = new Role();
			role.setName(rS.getString("name"));
			role.setCode(rS.getString("code"));
			role.setId(rS.getLong("roleId"));
			user.setRole(role);
			
			user.setCreateBy(rS.getString("createBy"));
			user.setModifyBy(rS.getString("modifyBy"));
			user.setCreateDate(rS.getTimestamp("createDate"));
			user.setModifyDate(rS.getTimestamp("modifyDate"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}

}
