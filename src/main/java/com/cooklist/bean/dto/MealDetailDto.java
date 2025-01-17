package com.cooklist.bean.dto;

public class MealDetailDto implements java.io.Serializable {

	private static final long serialVersionUID = -9161538630754711376L;
	private Integer id;
	private MealDto meal;
	private MeasuredIngredientDto measuredIngredient;
	private Double quantity;

	public MealDetailDto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MealDto getMeal() {
		return this.meal;
	}

	public void setMeal(MealDto meal) {
		this.meal = meal;
	}

	public MeasuredIngredientDto getMeasuredIngredient() {
		return this.measuredIngredient;
	}

	public void setMeasuredIngredient(MeasuredIngredientDto measuredIngredient) {
		this.measuredIngredient = measuredIngredient;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
