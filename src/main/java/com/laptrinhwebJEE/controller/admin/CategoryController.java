package com.laptrinhwebJEE.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhwebJEE.model.newCategory;
import com.laptrinhwebJEE.service.INewCategoryService;
import com.laptrinhwebJEE.utils.FormUtil;


@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryController extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public INewCategoryService ctgService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		newCategory model = new newCategory();
		String action = request.getParameter("action");
		String view = "";
		if(action != null) {
			if(action.equals("edit")) {
				long id = Integer.parseInt(request.getParameter("id"));
				model = ctgService.findById(id);
				System.out.println("Controller"+model.getDescription());
				view="/views/admin/categories/edit.jsp";
			} else if (action.equals("add")) {
				view="/views/admin/categories/edit.jsp";
			}
		} else {
			//Dùng để lấy các thông tin như (smaxPageItem, sortName, sortBy,... ) cho AbstractModel 
			model = FormUtil.toModel(newCategory.class, request);
			model.setlistResult(ctgService.findAll(model.getMaxPageItem(), model.getNextPage(), model.getSortName(), model.getSortBy()));
			double totalItem = ctgService.countCategory();
			model.setTotalPages((int) Math.ceil(totalItem/model.getMaxPageItem()));
			request.setAttribute("model", model);
			view="/views/admin/categories/list.jsp";
		}
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
