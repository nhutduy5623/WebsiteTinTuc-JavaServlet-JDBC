package com.laptrinhwebJEE.model;

public class Role extends AbstractModel<Role> {
	private long id;
	private String name;
	private String code;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(long id) {
		this.id = id;
	}
}
