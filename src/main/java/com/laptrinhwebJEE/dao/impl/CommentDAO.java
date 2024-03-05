package com.laptrinhwebJEE.dao.impl;

import java.util.List;

import com.laptrinhwebJEE.dao.ICommentDAO;
import com.laptrinhwebJEE.mapper.commentMapper;
import com.laptrinhwebJEE.mapper.newMapper;
import com.laptrinhwebJEE.model.Comment;
import com.laptrinhwebJEE.model.News;

public class CommentDAO extends AbstractDAO<Comment> implements ICommentDAO {

	@Override
	public long save(Comment cmt) {
		String sql = "INSERT INTO comment (newId, content, createBy, status, userId, cmtId) VALUES(?, ?, ?, ?, ?, ?)";
		if (cmt.getCmtId() == 0){
			sql = "INSERT INTO comment (newId, content, createBy, status, userId) VALUES(?, ?, ?, ?, ?)";
			return super.save(sql, cmt.getNewsId(), cmt.getContent(), cmt.getCreateBy(),  cmt.getStatus(), cmt.getuserId());
		}
		return super.save(sql, cmt.getNewsId(), cmt.getContent(), cmt.getCreateBy(),  cmt.getStatus(), cmt.getuserId(), cmt.getCmtId());
	}

	@Override
	public void update(Comment cmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> findCmtBypostId(Long postId) {
		String sql="SELECT * FROM comment WHERE newId = "+postId+" ORDER BY id ASC";
		List<Comment> cmts= super.query(sql, new commentMapper());
		return cmts;
	}

	@Override
	public List<Comment> findCmtBycmtId(Long cmtId) {
		String sql="SELECT * FROM comment WHERE cmtId = "+cmtId+" ORDER BY id ASC";
		List<Comment> cmts= super.query(sql, new commentMapper());
		return cmts;
	}

	@Override
	public Comment findcmtById(Long id) {
		String sql="SELECT * FROM comment WHERE id = "+id+" ORDER BY id DESC";
		List<Comment> cmts= super.query(sql, new commentMapper());
		return cmts.isEmpty() ? null : cmts.get(0);
	}

}
