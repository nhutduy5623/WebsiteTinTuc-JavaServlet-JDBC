package com.laptrinhwebJEE.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhwebJEE.dao.ICommentDAO;
import com.laptrinhwebJEE.model.Comment;
import com.laptrinhwebJEE.service.ICommentService;

public class CommentService implements ICommentService {
	
	@Inject
	ICommentDAO commentDAO;
	
	@Override
	public Comment save(Comment cmt) {
		Long id = commentDAO.save(cmt);
		System.out.println("-----Cmtidsave-----"+id);
		return commentDAO.findcmtById(id);
	}

	@Override
	public Comment update(Comment cmt) {
		return null;
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> findCmtBypostId(Long postId) {
		// TODO Auto-generated method stub
		return commentDAO.findCmtBypostId(postId);
	}

	@Override
	public List<Comment> findCmtBycmtId(Long cmtId) {
		// TODO Auto-generated method stub
		return commentDAO.findCmtBycmtId(cmtId);
	}

}
