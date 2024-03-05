package com.laptrinhwebJEE.dao;

import java.util.List;

import com.laptrinhwebJEE.model.newCategory;


public interface INewCategoryDAO extends GenericDAO<newCategory>{
	List<newCategory> findALl();
	List<newCategory> findALl(Integer firstItemIndex, Integer lastItemIndex, String sortName, String sortBy);
	int countCategory();
	newCategory findById(long id);
	newCategory findByCode(String ctgCode);
	long save(newCategory ctg);
	void update(newCategory ctg);
	void delete(Long id);
}
