package com.laptrinhwebJEE.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.model.newCategory;
import com.laptrinhwebJEE.service.INewCategoryService;
import com.laptrinhwebJEE.utils.HttpUtil;

/**
 * Servlet implementation class CategoryAPI
 */
@WebServlet(urlPatterns = {"/api-admin-category"})
public class CategoryAPI extends HttpServlet {
	
	@Inject 
	INewCategoryService ctgService;
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
				
//		Convert JSON to String -> Mapping Data JSON String of request with Model (Lưu dữ liệu dạng JSON từ request (thêm News) vào Model)
		newCategory category = HttpUtil.of(request.getReader()).toModel(newCategory.class);
		
		category = ctgService.save(category);		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), category);		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		newCategory category = HttpUtil.of(request.getReader()).toModel(newCategory.class);
		category = ctgService.update(category);
		mapper.writeValue(response.getOutputStream(), category);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Chạy");
		newCategory category = HttpUtil.of(request.getReader()).toModel(newCategory.class);
		ctgService.delete(category.getId());
		mapper.writeValue(response.getOutputStream(), "202");
	}
}
