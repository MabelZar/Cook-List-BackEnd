package com.cooklist.bean.dto;

public class MealDto implements java.io.Serializable {

	private static final long serialVersionUID = 2954989643024649705L;
	private Integer id;
	private String name;

	public MealDto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
