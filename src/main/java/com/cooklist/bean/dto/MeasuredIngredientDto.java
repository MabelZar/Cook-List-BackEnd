package com.cooklist.bean.dto;

public class MeasuredIngredientDto implements java.io.Serializable {

	private static final long serialVersionUID = -2101973684487315318L;
	private Integer id;
	private IngredientDto ingredient;
	private MeasurementUnitDto measurementUnit;

	public MeasuredIngredientDto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IngredientDto getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(IngredientDto ingredient) {
		this.ingredient = ingredient;
	}

	public MeasurementUnitDto getMeasurementUnit() {
		return this.measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnitDto measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

}
