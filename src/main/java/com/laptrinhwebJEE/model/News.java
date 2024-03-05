package com.laptrinhwebJEE.model;

public class News extends AbstractModel<News>{
	private long id;
	private String title;
	private String description;
	private String content;
	private String thumbnail ;
	private String categoryCode;
	private long newCategoryId ;
	private newCategory category;
	private int status = 1;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public long getCategoryId() {
		return newCategoryId;
	}
	public void setCategoryId(long categoryId) {
		this.newCategoryId = categoryId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public newCategory getCategory() {
		return category;
	}
	public void setCategory(newCategory category) {
		this.category = category;
		newCategoryId = category.getId();
		setCategoryCode(category.getCode());
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
}
