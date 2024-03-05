package com.laptrinhwebJEE.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhwebJEE.model.Comment;
import com.laptrinhwebJEE.service.ICommentService;
import com.laptrinhwebJEE.utils.HttpUtil;

/**
 * Servlet implementation class CommentAPI
 */
@WebServlet("/api-admin-comment")
public class CommentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	ICommentService cmtService;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");		
		ObjectMapper mapper = new ObjectMapper();
//		Convert JSON to String -> Mapping Data JSON String of request with Model (Lưu dữ liệu dạng JSON từ request (thêm News) vào Model)
		Comment cmt = HttpUtil.of(request.getReader()).toModel(Comment.class);
		cmt = cmtService.save(cmt);
		mapper.writeValue(response.getOutputStream(), cmt);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
