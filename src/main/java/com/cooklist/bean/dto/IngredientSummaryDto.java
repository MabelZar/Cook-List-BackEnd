package com.cooklist.bean.dto;

public class IngredientSummaryDto {

	private IngredientDto ingredient;
	private MeasurementUnitDto measurementUnit;
	private Double quantity;

	public IngredientDto getIngredient() {
		return ingredient;
	}

	public void setIngredient(IngredientDto ingredient) {
		this.ingredient = ingredient;
	}

	public MeasurementUnitDto getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnitDto measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
