package com.cooklist.bean.converter.impl;

import org.springframework.stereotype.Component;

import com.cooklist.bean.converter.ABeanConverter;
import com.cooklist.bean.dto.MealMeasuredIngredientDto;
import com.cooklist.bean.entity.view.MealMeasuredIngredientView;

@Component("mealMeasuredIngredientConverter")
public class MealMeasuredIngredientConverter
		extends ABeanConverter<MealMeasuredIngredientView, MealMeasuredIngredientDto> {

	@Override
	protected void populateDto(MealMeasuredIngredientDto dto, MealMeasuredIngredientView view) {

		dto.setMealDetailId(view.getMealDetailId());
		dto.setMeasuredIngredientId(view.getMeasuredIngredientId());
		dto.setIngredientId(view.getIngredientId());
		dto.setIngredientName(view.getIngredientName());
		dto.setMeasurementUnitId(view.getMeasurementUnitId());
		dto.setMeasurementUnitName(view.getMeasurementUnitName());
		dto.setMeasurementUnitSymbol(view.getMeasurementUnitSymbol());
		dto.setQuantity(view.getQuantity());

	}

	@Override
	protected void populateEntity(MealMeasuredIngredientView view, MealMeasuredIngredientDto dto) {

		view.setMealDetailId(dto.getMealDetailId());
		view.setMeasuredIngredientId(dto.getMeasuredIngredientId());
		view.setIngredientId(dto.getIngredientId());
		view.setIngredientName(dto.getIngredientName());
		view.setMeasurementUnitId(dto.getMeasurementUnitId());
		view.setMeasurementUnitName(dto.getMeasurementUnitName());
		view.setMeasurementUnitSymbol(dto.getMeasurementUnitSymbol());
		view.setQuantity(dto.getQuantity());

	}

	@Override
	protected MealMeasuredIngredientDto getNewDto() {
		return new MealMeasuredIngredientDto();
	}

	@Override
	protected MealMeasuredIngredientView getNewEntity() {
		return new MealMeasuredIngredientView();
	}

}
