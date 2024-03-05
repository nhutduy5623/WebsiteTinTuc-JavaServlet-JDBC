package com.laptrinhwebJEE.service;

import java.util.List;

import com.laptrinhwebJEE.model.newCategory;

public interface INewCategoryService {
	List<newCategory> findAll();
	int countCategory();
	List<newCategory> findAll(int limit, int pageNumber, String sortName, int sortBy);
	newCategory findById(Long id);
	newCategory findByCode(String ctgCode);
	newCategory save(newCategory ctg);
	newCategory update(newCategory ctg);
	void delete(Long id);
}
