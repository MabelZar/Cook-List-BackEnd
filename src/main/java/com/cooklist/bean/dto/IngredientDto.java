package com.cooklist.bean.dto;

public class IngredientDto implements java.io.Serializable {

	private static final long serialVersionUID = 8277049193836478646L;
	private Integer id;
	private String name;

	public IngredientDto() {
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
