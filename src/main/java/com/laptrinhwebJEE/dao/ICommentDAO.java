package com.laptrinhwebJEE.dao;

import java.util.List;

import com.laptrinhwebJEE.model.Comment;

public interface ICommentDAO extends GenericDAO<Comment>{
	long save(Comment cmt);
	void update(Comment cmt);
	void delete(Long id);
	Comment findcmtById(Long id);
	List<Comment> findCmtBypostId(Long postId);
	List<Comment> findCmtBycmtId(Long cmtId);
}
