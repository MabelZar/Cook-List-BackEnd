package com.cooklist.bean.dto;

public class MealMeasuredIngredientDto {

	private Integer mealDetailId;
	private Integer measuredIngredientId;
	private Integer ingredientId;
	private String ingredientName;
	private Integer measurementUnitId;
	private String measurementUnitName;
	private String measurementUnitSymbol;
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

	public Integer getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Integer getMeasurementUnitId() {
		return measurementUnitId;
	}

	public void setMeasurementUnitId(Integer measurementUnitId) {
		this.measurementUnitId = measurementUnitId;
	}

	public String getMeasurementUnitName() {
		return measurementUnitName;
	}

	public void setMeasurementUnitName(String measurementUnitName) {
		this.measurementUnitName = measurementUnitName;
	}

	public String getMeasurementUnitSymbol() {
		return measurementUnitSymbol;
	}

	public void setMeasurementUnitSymbol(String measurementUnitSymbol) {
		this.measurementUnitSymbol = measurementUnitSymbol;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
