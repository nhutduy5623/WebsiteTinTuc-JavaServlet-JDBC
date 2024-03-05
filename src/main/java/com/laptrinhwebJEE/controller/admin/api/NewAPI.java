package com.laptrinhwebJEE.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
	
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.service.INewCategoryService;
import com.laptrinhwebJEE.service.INewService;
import com.laptrinhwebJEE.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
	
	@Inject
	private INewService NewService;
	
	@Inject
	private INewCategoryService ctgService;
	
	private static final long serialVersionUID = 521231287642089805L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");		
		ObjectMapper mapper = new ObjectMapper();
//		Convert JSON to String -> Mapping Data JSON String of request with Model (Lưu dữ liệu dạng JSON từ request (thêm News) vào Model)
		News news = HttpUtil.of(request.getReader()).toModel(News.class);
		news.setThumbnail("uploads/"+news.getThumbnail());
		news.setCategory(ctgService.findByCode(news.getCategoryCode()));
		news = NewService.save(news);
		
		mapper.writeValue(response.getOutputStream(), news);
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		News update_news = HttpUtil.of(request.getReader()).toModel(News.class);
		update_news = NewService.update(update_news);
		mapper.writeValue(response.getOutputStream(), update_news);
		
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		News delete_news = HttpUtil.of(request.getReader()).toModel(News.class);
		NewService.delete(delete_news.getId());
		mapper.writeValue(response.getOutputStream(), "202");

	}
}
