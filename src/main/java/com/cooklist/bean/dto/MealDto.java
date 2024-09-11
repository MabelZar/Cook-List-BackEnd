package com.cooklist.bean.dto;

import java.util.List;

public class MealDto implements java.io.Serializable {

	private static final long serialVersionUID = 2954989643024649705L;
	private Integer id;
	private String name;
	private List<MealMeasuredIngredientDto> mealMeasuredIngredientDtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MealMeasuredIngredientDto> getMealMeasuredIngredientDtos() {
		return mealMeasuredIngredientDtos;
	}

	public void setMealMeasuredIngredientDtos(List<MealMeasuredIngredientDto> mealMeasuredIngredientDtos) {
		this.mealMeasuredIngredientDtos = mealMeasuredIngredientDtos;
	}

}
