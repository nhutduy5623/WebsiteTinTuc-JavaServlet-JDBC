package com.laptrinhwebJEE.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhwebJEE.dao.INewCategoryDAO;
import com.laptrinhwebJEE.mapper.newCategoryMapper;
import com.laptrinhwebJEE.mapper.newMapper;
import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.model.newCategory;

public class NewCategoryDAO extends AbstractDAO<newCategory> implements INewCategoryDAO {
	@Override
	public List<newCategory> findALl() {
		List<newCategory> results = new ArrayList<>();
		String sql = "SELECT * FROM newCategory";
		return query(sql, new newCategoryMapper());
	}

	@Override
	public List<newCategory> findALl(Integer firstItemIndex, Integer lastItemIndex, String sortName, String sortBy) {
		List<newCategory> results = new ArrayList<>();
		StringBuilder sql= new StringBuilder("SELECT * FROM newCategory");
		if (sortName != null && sortBy != null)
			sql.append(" ORDER BY "+sortName+" "+sortBy+"");
		if (firstItemIndex != null && lastItemIndex != null)
			sql.append(" LIMIT "+firstItemIndex+", "+lastItemIndex+"");
		results = query(sql.toString(), new newCategoryMapper());
		return results;
	}

	@Override
	public int countCategory() {
		String sql="SELECT COUNT(*) FROM newCategory";
		return super.count(sql);
	}

	@Override
	public newCategory findById(long id) {
		String sql="SELECT * FROM newCategory WHERE id=?";
		List<newCategory> results = query(sql, new newCategoryMapper(), id);
		newCategory ctg = results.get(0);
		System.out.println("Dao"+ctg.getDescription());
		return ctg;
	}
	
	@Override
	public newCategory findByCode(String ctgCode) {
		String sql="SELECT * FROM newCategory WHERE code=?";
		List<newCategory> results = query(sql, new newCategoryMapper(), ctgCode);
		
		newCategory ctg = results.get(0);
		System.out.println("Dao"+ctg.getDescription());
		return ctg;
	}

	@Override
	public long save(newCategory ctg) {
		String sql = "INSERT INTO newcategory(typeName, description, code) values(?, ?, ?)";
		return save(sql, ctg.getTypeName(), ctg.getDescription(), ctg.getCode());
	}

	@Override
	public void update(newCategory ctg) {
		String sql = "UPDATE newcategory SET typeName = ?, description = ?, code = ? WHERE id = ?";
		update(sql, ctg.getTypeName(), ctg.getDescription(), ctg.getCode(), ctg.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM newcategory WHERE id = +"+id+"";
		delete(sql);
	}

	
}
