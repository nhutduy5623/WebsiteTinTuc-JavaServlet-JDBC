package com.laptrinhwebJEE.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.model.newCategory;

public class newMapper implements IRowMapper<News> {

	@Override
	public News mapperRow(ResultSet rS) {
		News news = new News();
		try {
			news.setId(rS.getLong("id"));
			news.setTitle(rS.getString("title"));
			news.setDescription(rS.getString("description"));
			news.setThumbnail(rS.getString("thumbnail"));
			news.setContent(rS.getString("content"));
			news.setCategoryId(rS.getLong("newCategoryId"));
			news.setStatus(rS.getInt("status"));
			news.setCreateBy(rS.getString("createBy"));
			news.setModifyBy(rS.getString("modifyBy"));
			news.setCreateDate(rS.getTimestamp("createDate"));
			news.setModifyDate(rS.getTimestamp("modifyDate"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
