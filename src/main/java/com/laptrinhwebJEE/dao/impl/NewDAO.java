package com.laptrinhwebJEE.dao.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhwebJEE.dao.INewDAO;
import com.laptrinhwebJEE.mapper.newMapper;
import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.service.impl.NewCategoryService;

public class NewDAO extends AbstractDAO<News> implements INewDAO {

	@Inject
	NewCategoryService ctgService;
	
	@Override
	public List<News> findNewsByCategoryId(Long CategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
	@Override
	public Long save(News news) {
		String sql = "INSERT INTO news(title, description, thumbnail, content, newCategoryId, status) values(?, ?, ?, ?, ?, ?)";
		Long id = super.save(sql, news.getTitle(), news.getDescription(), news.getThumbnail(), news.getContent(), news.getCategoryId(), news.getStatus());
		return id;
	}

	@Override
	public void update(News news) {
		String sql = "UPDATE news SET \r\n" + 
				"title =?, description =?, thumbnail =?, content =?, newCategoryId =?, status =?, createDate =?, modifyDate =?, createBy =?, modifyBy =?  WHERE id = ? ";
		super.update(sql, news.getTitle(), news.getDescription(), news.getThumbnail(), news.getContent(), news.getCategoryId(), news.getStatus(), news.getCreateDate(), news.getModifyDate(), news.getCreateBy(), news.getModifyBy(), news.getId()	);	
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM news WHERE id=?";
		super.update(sql, id);	
		
	}

	@Override
	public News findOne(Long id) {
		String sql="SELECT * FROM news WHERE id = ?";
		List<News> news= super.query(sql, new newMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}


	
	@Override
	public List<News> findAll(String categoryCode, Integer firstItemIndex, Integer lastItemIndex, String sortName, String sortBy) {
		StringBuilder sql= new StringBuilder("SELECT * FROM news");
		if (categoryCode != "") 
			sql = new StringBuilder("SELECT * FROM news n, newcategory c WHERE n.newCategoryId=c.id and c.code = '"+categoryCode+"'");
		if (sortName != null && sortBy != null)
			sql.append(" ORDER BY "+sortName+" "+sortBy+"");
		if (firstItemIndex != null && lastItemIndex != null)
			sql.append(" LIMIT "+firstItemIndex+", "+lastItemIndex+"");
		List<News> news= super.query(sql.toString(), new newMapper());
		
		
		if(news!=null)
		news.forEach((element) -> {
			element.setCategory(ctgService.findById(element.getCategoryId()));
		});
		return news;
	}



	@Override
	public List<News> findPage(int firstItemIndex, int lastItemIndex) {
		String sql="SELECT * FROM news LIMIT ?, ? ";
		List<News> news= super.query(sql, new newMapper(), firstItemIndex, lastItemIndex);
		return news;
	}



	@Override
	public int countNews() {
		String sql="SELECT COUNT(*) FROM news";
		return super.count(sql);
	}
	
	
	@Override
	public int countNews(String categoryCode) {
		String sql="SELECT COUNT(*) FROM news n, newcategory c WHERE n.newCategoryId=c.id and c.code = '"+categoryCode+"'";
		return super.count(sql);
	}


	

}
