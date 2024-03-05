package com.laptrinhwebJEE.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhwebJEE.dao.INewCategoryDAO;
import com.laptrinhwebJEE.model.newCategory;
import com.laptrinhwebJEE.service.INewCategoryService;
//Using Java Servlet Weld
public class NewCategoryService implements INewCategoryService{
	@Inject
	private INewCategoryDAO categoryDAO;
	
	@Override
	public List<newCategory> findAll() {
		return categoryDAO.findALl();
	}
	
	

	@Override
	public List<newCategory> findAll(int limit, int pageNumber, String sortName, int sortBy) {
		int firstItemIndex = (pageNumber-1)*limit;
		String sSortBy = "ASC";
		if (sortBy == 2)
			sSortBy = "DESC";
		return categoryDAO.findALl(firstItemIndex, limit+firstItemIndex, sortName, sSortBy);
	}

	@Override
	public int countCategory() {
		return categoryDAO.countCategory();
	}

	@Override
	public newCategory findById(Long id) {
		return categoryDAO.findById(id);
	}

	@Override
	public newCategory save(newCategory ctg) {
		Long id = categoryDAO.save(ctg);
		return categoryDAO.findById(id);
	}

	@Override
	public newCategory update(newCategory ctg) {
		categoryDAO.update(ctg);
		return categoryDAO.findById(ctg.getId());
	}

	@Override
	public void delete(Long id) {
		categoryDAO.delete(id);		
	}

	@Override
	public newCategory findByCode(String ctgCode) {
		return categoryDAO.findByCode(ctgCode);
	}
	
}
