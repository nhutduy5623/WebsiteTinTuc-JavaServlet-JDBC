package com.laptrinhwebJEE.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhwebJEE.dao.INewDAO;
import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDAO newsDAO;
	
	@Override
	public News save(News news) {
//		System.out.println(new Timestamp(System.currentTimeMillis()));
//		Timestamp t = new Timestamp(System.currentTimeMillis());
//		System.out.println(news);
//		news.setCreateDate(t);
//		news.setModifyDate(new Timestamp(System.currentTimeMillis()));
		Long id = this.newsDAO.save(news);
		return newsDAO.findOne(id);
	}
	@Override
	public News update(News update_news) {
		update_news.setModifyDate(new Timestamp(System.currentTimeMillis()));
		this.newsDAO.update(update_news);
		return newsDAO.findOne(update_news.getId());
	}
	@Override
	public void delete(Long id) {
		this.newsDAO.delete(id);		
	}
	@Override
	public List<News> findAll(String categoryCode, int limit, int pageNumber, String sortName, int sortBy) {
		int firstItemIndex = (pageNumber-1)*limit;
		String sSortBy = "ASC";
		if (sortBy == 2)
			sSortBy = "DESC";
		return newsDAO.findAll(categoryCode, firstItemIndex, limit+firstItemIndex, sortName, sSortBy);
	}
	@Override
	public List<News> findPage(int limit, int pageNumber) {
		int firstItemIndex = (pageNumber-1)*limit;
		return newsDAO.findPage(firstItemIndex, limit+firstItemIndex);
	}
	@Override
	public int countNews() {
		return newsDAO.countNews();
	}
	@Override
	public News findOne(Long id) {
		// TODO Auto-generated method stub
		return newsDAO.findOne(id);
	}
	@Override
	public int countNews(String categoryCode) {
		// TODO Auto-generated method stub
		return newsDAO.countNews(categoryCode);
	}

}
