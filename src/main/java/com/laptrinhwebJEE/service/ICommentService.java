package com.laptrinhwebJEE.service;

import java.util.List;

import com.laptrinhwebJEE.model.Comment;

public interface ICommentService {
	Comment save(Comment cmt);
	Comment update(Comment cmt);
	void delete(Long id);
	List<Comment> findCmtBypostId(Long postId);
	List<Comment> findCmtBycmtId(Long cmtId);
}
