package com.laptrinhwebJEE.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebJEE.model.newCategory;

public class newCategoryMapper implements IRowMapper<newCategory> {

	@Override
	public newCategory mapperRow(ResultSet rS) {
		newCategory ctg = new newCategory();
		try {
			ctg.setId(rS.getLong("id"));
			ctg.setCode(rS.getString("code"));
			ctg.setDescription(rS.getString("description"));
			ctg.setTypeName(rS.getString("TypeName"));
			return ctg;
		} catch (SQLException e) {
			e.printStackTrace();
			return ctg;
		}	

	}
	
}
