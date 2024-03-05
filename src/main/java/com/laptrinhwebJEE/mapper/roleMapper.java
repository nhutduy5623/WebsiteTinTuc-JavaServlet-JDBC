package com.laptrinhwebJEE.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebJEE.model.Role;

public class roleMapper implements IRowMapper<Role> {
	@Override
	public Role mapperRow(ResultSet rS) {
		Role role = new Role();
		try {
			role.setCode(rS.getString("code"));
			role.setName(rS.getString("Name"));
			role.setId(rS.getLong("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	
}
