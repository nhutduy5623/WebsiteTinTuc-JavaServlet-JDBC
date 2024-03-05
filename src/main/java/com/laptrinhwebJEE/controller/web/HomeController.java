package com.laptrinhwebJEE.controller.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhwebJEE.model.News;
import com.laptrinhwebJEE.model.User;
import com.laptrinhwebJEE.service.INewCategoryService;
import com.laptrinhwebJEE.service.INewService;
import com.laptrinhwebJEE.service.IUserService;
import com.laptrinhwebJEE.utils.FormUtil;
import com.laptrinhwebJEE.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/dang-ky", "/thoat"})
public class HomeController extends HttpServlet {
	
	@Inject
	private INewCategoryService categoryService;
	
	@Inject
	private INewService newService;
	
	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//newService.delete(9L);
		
		String action = request.getParameter("action");
		if(action != null) {
			if(action.equals("login")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
				rd.forward(request, response);	
			} else if(action.equals("register")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/login/register.jsp");				
				rd.forward(request, response);	
			} else if(action.equals("logout")) {
				SessionUtil session = SessionUtil.getInstance();
				session.removeValue(request, "currentUSER");
				response.sendRedirect(request.getContextPath()+"/trang-chu?nextPage=1&maxPageItem=5&sortName=createDate&sortBy=1");

			}
					
		} else {
			request.setAttribute("Categorys", categoryService.findAll());
			
			News model = new News();
			
			model = FormUtil.toModel(News.class, request);
			
			String categoryCode = request.getParameter("ctg");
			System.out.println(categoryCode);
			if (categoryCode==null || categoryCode.equals(""))
				categoryCode="";
				
			model.setlistResult(newService.findAll(categoryCode, model.getMaxPageItem(), model.getNextPage(), model.getSortName(), model.getSortBy()));
			double totalItem = 0;
			if (categoryCode.equals("")) {
				totalItem = newService.countNews();
			} else {
				totalItem = newService.countNews(categoryCode);
			}
			model.setTotalPages((int) Math.ceil(totalItem/model.getMaxPageItem()));
			request.setAttribute("model", model);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action !=null) {
			if(action.equals("login")) {
				User model = new User();
				model = FormUtil.toModel(User.class, request);
				model = userService.findUserLogin(model);
				if(model!=null) {
					SessionUtil session = SessionUtil.getInstance();
					session.putValue(request, "currentUSER", model);
					if (model.getRole().getCode().equals("USER")) {
						response.sendRedirect(request.getContextPath()+"/");
					} else if(model.getRole().getCode().equals("ADMIN")) {
						response.sendRedirect(request.getContextPath()+"/admin-home");
					}
				} else {
					PrintWriter out = response.getWriter();
					request.setAttribute("MessageErro", "Sai thông tin đăng nhập!");
					RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");				
					rd.forward(request, response);
				}
			} else if (action.equals("register")) {
				User model = new User();
				model = FormUtil.toModel(User.class, request);
				model.getRole().setId(1);
				model.setStatus(1);
				String Mess = userService.registerUser(model);
				if(Mess.equals("User exists!")) {			
					request.setAttribute("Message", Mess);
					RequestDispatcher rd = request.getRequestDispatcher("/views/login/register.jsp");				
					rd.forward(request, response);					
				} else {
					Mess = "Finish!";	
					request.setAttribute("Message", Mess);
					RequestDispatcher rd = request.getRequestDispatcher("/views/login/register.jsp");				
					rd.forward(request, response);
				}				
			} else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
				
			}
			
		}
	
	}
}