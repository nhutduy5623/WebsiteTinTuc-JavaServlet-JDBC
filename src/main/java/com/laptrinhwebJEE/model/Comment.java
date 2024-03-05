package com.laptrinhwebJEE.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Comment extends AbstractModel<Comment>{
	private long id;
	private long newsId;
	private String content;
	private int likeCount;
	private long userId;
	private long cmtId = 0;
	private int status = 1;
	private List<Comment> listCmtResponse = new ArrayList<>();
	
	public void setCreateCurrentDate() {
		System.out.println(new Timestamp(System.currentTimeMillis()));
		super.setCreateDate(new Timestamp(System.currentTimeMillis()));
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public long getuserId() {
		return this.userId;
	}
	public void setuserId(long createBy) {
		this.userId = createBy;
	}
	public long getCmtId() {
		return cmtId;
	}
	public void setCmtId(long cmtId) {
		this.cmtId = cmtId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public List<Comment> getListCmtResponse() {
		return listCmtResponse;
	}

	public void setListCmtResponse(List<Comment> listCmtResponse) {
		this.listCmtResponse = listCmtResponse;
	}
	
}
