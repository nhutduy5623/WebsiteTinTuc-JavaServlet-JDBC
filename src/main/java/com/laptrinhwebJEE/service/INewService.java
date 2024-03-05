package com.laptrinhwebJEE.service;

import java.util.List;

import com.laptrinhwebJEE.model.News;

public interface INewService {
	News save(News news);
	News update(News update_news);
	void delete(Long id);
	List<News> findAll(String categoryCode, int limit, int pageNumber, String sortName, int sortBy);
	List<News> findPage(int limit, int pageNumber);
	int countNews();
	int countNews(String categoryCode);
	News findOne(Long id);
}
