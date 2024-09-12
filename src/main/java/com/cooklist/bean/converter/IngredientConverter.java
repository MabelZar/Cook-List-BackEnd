package com.cooklist.bean.converter;

import org.springframework.stereotype.Component;

import com.cooklist.bean.dto.IngredientDto;
import com.cooklist.bean.entity.IngredientEntity;

@Component("ingredientConverter")
public class IngredientConverter extends BeanConverterImpl<IngredientEntity, IngredientDto> {

	@Override
	protected void populateDto(IngredientDto dto, IngredientEntity entity) {

		dto.setId(entity.getId());
		dto.setName(entity.getName());

	}

	@Override
	protected void populateEntity(IngredientEntity entity, IngredientDto dto) {

		entity.setId(dto.getId());
		entity.setName(dto.getName());

	}

	@Override
	protected IngredientDto getNewDto() {
		return new IngredientDto();
	}

	@Override
	protected IngredientEntity getNewEntity() {
		return new IngredientEntity();
	}

}
