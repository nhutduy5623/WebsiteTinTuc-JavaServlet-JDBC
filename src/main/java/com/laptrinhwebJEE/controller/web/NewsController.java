package com.laptrinhwebJEE.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhwebJEE.model.Comment;
import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.service.ICommentService;
import com.laptrinhwebJEE.service.INewCategoryService;
import com.laptrinhwebJEE.service.INewService;
import com.laptrinhwebJEE.service.impl.CommentService;

/**
 * Servlet implementation class NewsController
 */
@WebServlet(urlPatterns = {"/newsPost"})
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private INewService newService;
	
	@Inject
	private ICommentService cmtService;
	
	@Inject
	private INewCategoryService ctgService; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPost = request.getParameter("id");
		if(idPost!="" && idPost!= null) {
			News news = new News();
			Comment cmt = new Comment();
			
			news.setId(Long.parseLong(idPost));
			news = newService.findOne(news.getId());
			cmt.setlistResult(cmtService.findCmtBypostId(Long.parseLong(idPost)));
			System.out.println(cmt.getlistResult());
			int j=0;
			for (Comment i : cmt.getlistResult()) {
				cmt.getlistResult().get(j).setListCmtResponse(cmtService.findCmtBycmtId(i.getId()));
				j++;	
			}
			System.out.println();
			request.setAttribute("Categorys", ctgService.findAll());

			request.setAttribute("comment", cmt);		
			request.setAttribute("model", news);
		}
		RequestDispatcher rd = request.getRequestDispatcher("views/web/postnews.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
