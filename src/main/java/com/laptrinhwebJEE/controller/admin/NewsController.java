package com.laptrinhwebJEE.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.model.newCategory;
import com.laptrinhwebJEE.service.INewCategoryService;
import com.laptrinhwebJEE.service.INewService;
import com.laptrinhwebJEE.utils.FormUtil;


@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

	@Inject
	private INewService newService;
	
	@Inject
	private INewCategoryService ctgService;
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News model = new News();
		String views = "/views/admin/news/list.jsp";
		String action = request.getParameter("action");
		if(action !="" && action != null) {
			newCategory ctg = new newCategory();
			ctg.setlistResult(ctgService.findAll());
			request.setAttribute("Category", ctg);
			if(action.equals("add")) {
				views = "/views/admin/news/edit.jsp";
			} else if (action.equals("edit")) {
				Long id = Long.parseLong(request.getParameter("id"));
				views = "/views/admin/news/edit.jsp";
			}			
		} else {
	//		String smaxPageItem = request.getParameter("maxPageItem");
	//		String sNextPage = request.getParameter("nextPage");
	//		String sortName = request.getParameter("sortName");
	//		String sortBy = request.getParameter("sortBy");
	//		if (smaxPageItem != null ) model.setMaxPageItem(Integer.parseInt(smaxPageItem));
	//		if (sNextPage != null) model.setNextPage(Integer.parseInt(sNextPage));
	//		if (sortBy != null) model.setSortBy(Integer.parseInt(sortBy));
	//		if (sortName != null) model.setSortName(sortName);	
	//		^^^^^				   ^^^^^
	//		|||||Thay cho đoạn trên|||||
			model = FormUtil.toModel(News.class, request);
			
			model.setlistResult(newService.findAll("", model.getMaxPageItem(), model.getNextPage(), model.getSortName(), model.getSortBy()));
			double totalItem = newService.countNews();
			model.setTotalPages((int) Math.ceil(totalItem/model.getMaxPageItem()));
			}
			request.setAttribute("model", model);
			RequestDispatcher rd = request.getRequestDispatcher(views);
			rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}