package com.cooklist.bean.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cooklist.bean.converter.ABeanConverter;
import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.MealDto;
import com.cooklist.bean.dto.MealProgrammingDto;
import com.cooklist.bean.entity.AppUserEntity;
import com.cooklist.bean.entity.MealEntity;
import com.cooklist.bean.entity.MealProgrammingEntity;

@Component("mealProgrammingConverter")
public class MealProgrammingConverterImpl extends ABeanConverter<MealProgrammingEntity, MealProgrammingDto> {

	@Autowired
	@Qualifier("appUserConverter")
	BeanConverter<AppUserEntity, AppUserDto> appUserConverter;

	@Autowired
	@Qualifier("mealConverter")
	BeanConverter<MealEntity, MealDto> mealConverter;

	@Override
	protected void populateDto(MealProgrammingDto dto, MealProgrammingEntity entity) {

		dto.setId(entity.getId());
		dto.setProgramming(entity.getProgramming());

		dto.setAppUser(appUserConverter.convertToDto(entity.getAppUser()));
		dto.setMeal(mealConverter.convertToDto(entity.getMeal()));

	}

	@Override
	protected void populateEntity(MealProgrammingEntity entity, MealProgrammingDto dto) {

		entity.setId(dto.getId());
		entity.setProgramming(dto.getProgramming());

		entity.setAppUser(appUserConverter.convertToEntity(dto.getAppUser()));
		entity.setMeal(mealConverter.convertToEntity(dto.getMeal()));

	}

	@Override
	protected MealProgrammingDto getNewDto() {
		return new MealProgrammingDto();
	}

	@Override
	protected MealProgrammingEntity getNewEntity() {
		return new MealProgrammingEntity();
	}

}
