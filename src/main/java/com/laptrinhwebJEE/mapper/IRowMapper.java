package com.laptrinhwebJEE.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	<T> T mapperRow(ResultSet rS);
}
