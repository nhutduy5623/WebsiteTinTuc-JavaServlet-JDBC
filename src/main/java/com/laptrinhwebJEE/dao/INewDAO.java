package com.laptrinhwebJEE.dao;

import java.util.List;

import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.model.User;

public interface INewDAO extends GenericDAO<News> {
	List<News> findNewsByCategoryId(Long CategoryId);
	List<News> findAll(String categoryCode, Integer firstItemIndex, Integer lastItemIndex, String sortName, String sortBy);
	List<News> findPage(int firstItemIndex, int lastItemIndex);
	int countNews();
	int countNews(String categoryCode);
	News findOne(Long id);
	Long save(News news);
	void update(News news);
	void delete(Long id);
}
