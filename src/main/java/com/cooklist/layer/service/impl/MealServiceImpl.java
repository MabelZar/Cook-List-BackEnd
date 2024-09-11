package com.cooklist.layer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.MealBodyDto;
import com.cooklist.bean.dto.MealDto;
import com.cooklist.bean.entity.IngredientEntity;
import com.cooklist.bean.entity.MealDetailEntity;
import com.cooklist.bean.entity.MealEntity;
import com.cooklist.bean.entity.MeasuredIngredientEntity;
import com.cooklist.bean.entity.MeasurementUnitEntity;
import com.cooklist.layer.repository.MealRepository;
import com.cooklist.layer.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealRepository mealRepository;

	@Autowired
	@Qualifier("mealConverter")
	private BeanConverter<MealEntity, MealDto> mealConverter;

	@Override
	public List<MealDto> getAll() {

		List<MealEntity> entities = mealRepository.findAll();

		return mealConverter.convertToDtos(entities);
	}

	@Override
	public MealDto findById(Integer mealId) {

		MealEntity entity = mealRepository.getReferenceById(mealId);
		
		MealDto dto = mealConverter.convertToDto(entity);
		dto.setMealBodyDtos(new ArrayList<MealBodyDto>());
		
		for(MealDetailEntity mealDetailEntity : entity.getMealDetails()) {

			MeasuredIngredientEntity measuredIngredientEntity = mealDetailEntity.getMeasuredIngredient();
			IngredientEntity ingredientEntity = measuredIngredientEntity.getIngredient();
			MeasurementUnitEntity measurementUnitEntity = measuredIngredientEntity.getMeasurementUnit();
			
			MealBodyDto mealBodyDto = new MealBodyDto();
			mealBodyDto.setMealDetailId(mealDetailEntity.getId());
			mealBodyDto.setMeasuredIngredientId(measuredIngredientEntity.getId());
			mealBodyDto.setMeasuredIngredientName(ingredientEntity.getName() + " - " + measurementUnitEntity.getSymbol());
			mealBodyDto.setQuantity(mealDetailEntity.getQuantity().doubleValue());
		
			dto.getMealBodyDtos().add(mealBodyDto);
		}

		return dto;
	}

	@Override
	public List<MealDto> findByName(String name) {

		String nameLowerCase = StringUtils.lowerCase(name);

		List<MealEntity> entities = mealRepository.findByName(nameLowerCase);

		return mealConverter.convertToDtos(entities);

	}

	@Override
	public void createOrUpdate(MealDto dto) {

	}

	@Override
	public void deleteById(Integer mealId) {

		mealRepository.deleteById(mealId);

	}

}
