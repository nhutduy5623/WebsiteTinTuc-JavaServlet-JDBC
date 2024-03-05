package com.laptrinhwebJEE.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebJEE.model.Comment;

public class commentMapper implements IRowMapper<Comment> {

		
	@Override
	public Comment mapperRow(ResultSet rS) {
		Comment cmt = new Comment();
		try {
			cmt.setId(rS.getLong("id"));
			cmt.setNewsId(rS.getLong("newId"));
			cmt.setContent(rS.getString("content"));
			cmt.setuserId(rS.getLong("userId"));
			cmt.setCreateBy(rS.getString("createBy"));
			cmt.setCreateDate(rS.getTimestamp("createDate"));
			cmt.setCmtId(rS.getLong("cmtId"));
			return cmt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
