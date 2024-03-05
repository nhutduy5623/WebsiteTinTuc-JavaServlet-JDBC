package com.laptrinhwebJEE.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private String createBy = "";
	private String modifyBy = "";
	private Timestamp createDate;
	private Timestamp ModifyDate;	
	private List<T> listResult = new ArrayList<>();
	private Integer totalPages=1;
	private Integer nextPage = 1;
	private Integer maxPageItem = 4;
	private Integer sortBy;
	private String sortName;
	private String ctg="";
	public Integer getSortBy() {
		return sortBy;
	}
	public void setSortBy(Integer sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	
	public Timestamp getModifyDate() {
		return ModifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		ModifyDate = modifyDate;
	}
	public List<T> getlistResult() {
		return listResult;
	}
	public void setlistResult(List<T> listResult) {
		this.listResult = listResult;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public String getCtg() {
		return ctg;
	}
	public void setCtg(String ctg) {
		this.ctg = ctg;
	}	
}
