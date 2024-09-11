package com.cooklist.bean.dto;

public class MealBodyDto {

	private Integer mealDetailId;
	private Integer measuredIngredientId;
	private String measuredIngredientName;
	private Double quantity;

	public Integer getMealDetailId() {
		return mealDetailId;
	}

	public void setMealDetailId(Integer mealDetailId) {
		this.mealDetailId = mealDetailId;
	}

	public Integer getMeasuredIngredientId() {
		return measuredIngredientId;
	}

	public void setMeasuredIngredientId(Integer measuredIngredientId) {
		this.measuredIngredientId = measuredIngredientId;
	}

	public String getMeasuredIngredientName() {
		return measuredIngredientName;
	}

	public void setMeasuredIngredientName(String measuredIngredientName) {
		this.measuredIngredientName = measuredIngredientName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
