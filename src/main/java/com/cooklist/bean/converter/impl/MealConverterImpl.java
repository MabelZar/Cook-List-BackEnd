package com.cooklist.bean.converter.impl;

import org.springframework.stereotype.Component;

import com.cooklist.bean.converter.ABeanConverter;
import com.cooklist.bean.dto.MealDto;
import com.cooklist.bean.entity.MealEntity;

@Component("mealConverter")
public class MealConverterImpl extends ABeanConverter<MealEntity, MealDto> {

	@Override
	protected void populateDto(MealDto dto, MealEntity entity) {

		dto.setId(entity.getId());
		dto.setName(entity.getName());

	}

	@Override
	protected void populateEntity(MealEntity entity, MealDto dto) {

		entity.setId(dto.getId());
		entity.setName(dto.getName());

	}

	@Override
	protected MealDto getNewDto() {
		return new MealDto();
	}

	@Override
	protected MealEntity getNewEntity() {
		return new MealEntity();
	}

}
