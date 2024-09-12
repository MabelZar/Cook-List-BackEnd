package com.cooklist.bean.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cooklist.bean.dto.IngredientDto;
import com.cooklist.bean.dto.MeasuredIngredientDto;
import com.cooklist.bean.dto.MeasurementUnitDto;
import com.cooklist.bean.entity.IngredientEntity;
import com.cooklist.bean.entity.MeasuredIngredientEntity;
import com.cooklist.bean.entity.MeasurementUnitEntity;

@Component("measuredIngredientConverter")
public class MeasuredIngredientConverter extends BeanConverterImpl<MeasuredIngredientEntity, MeasuredIngredientDto> {

	@Autowired
	@Qualifier("ingredientConverter")
	private BeanConverter<IngredientEntity, IngredientDto> ingredientConverter;

	@Autowired
	@Qualifier("measurementUnitConverter")
	private BeanConverter<MeasurementUnitEntity, MeasurementUnitDto> measurementUnitConverter;
	
	@Override
	protected void populateDto(MeasuredIngredientDto dto, MeasuredIngredientEntity entity) {

		dto.setId(entity.getId());
		dto.setIngredient(ingredientConverter.convertToDto(entity.getIngredient()));
		dto.setMeasurementUnit(measurementUnitConverter.convertToDto(entity.getMeasurementUnit()));

	}

	@Override
	protected void populateEntity(MeasuredIngredientEntity entity, MeasuredIngredientDto dto) {

		entity.setId(dto.getId());

	}

	@Override
	protected MeasuredIngredientDto getNewDto() {
		return new MeasuredIngredientDto();
	}

	@Override
	protected MeasuredIngredientEntity getNewEntity() {
		return new MeasuredIngredientEntity();
	}

}
