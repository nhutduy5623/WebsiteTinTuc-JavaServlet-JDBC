package com.laptrinhwebJEE.dao;

import java.util.List;

import com.laptrinhwebJEE.mapper.IRowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
	int count(String sql, Object... parameters);
	<T> Long save(String sql, Object... parameters);
	void update(String sql, Object... parameters);
	void delete(String sql, Object... parameters);
}
