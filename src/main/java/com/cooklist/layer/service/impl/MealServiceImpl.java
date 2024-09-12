package com.cooklist.layer.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.MealDto;
import com.cooklist.bean.dto.MealMeasuredIngredientDto;
import com.cooklist.bean.entity.MealDetailEntity;
import com.cooklist.bean.entity.MealEntity;
import com.cooklist.bean.entity.MeasuredIngredientEntity;
import com.cooklist.bean.entity.view.MealMeasuredIngredientView;
import com.cooklist.layer.repository.MealDetailRepository;
import com.cooklist.layer.repository.MealProgrammingRepository;
import com.cooklist.layer.repository.MealRepository;
import com.cooklist.layer.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealRepository mealRepository;

	@Autowired
	private MealDetailRepository mealDetailRepository;

	@Autowired
	private MealProgrammingRepository mealProgrammingRepository;

	@Autowired
	@Qualifier("mealConverter")
	private BeanConverter<MealEntity, MealDto> mealConverter;

	@Autowired
	@Qualifier("mealMeasuredIngredientConverter")
	private BeanConverter<MealMeasuredIngredientView, MealMeasuredIngredientDto> mealMeasuredIngredientConverter;

	@Override
	public List<MealDto> getAll() {

		List<MealEntity> entities = mealRepository.findAll();

		return mealConverter.convertToDtos(entities);
	}

	@Override
	public MealDto findById(Integer mealId) {

		MealEntity entity = mealRepository.getReferenceById(mealId);

		MealDto dto = mealConverter.convertToDto(entity);
		dto.setMealMeasuredIngredientDtos(new ArrayList<MealMeasuredIngredientDto>());

		List<MealMeasuredIngredientView> mealMeasuredIngredientViews = mealProgrammingRepository
				.calculateIngredients(mealId);

		for (MealMeasuredIngredientView mealMeasuredIngredientView : mealMeasuredIngredientViews) {

			MealMeasuredIngredientDto mealMeasuredIngredientDto = mealMeasuredIngredientConverter
					.convertToDto(mealMeasuredIngredientView);

			dto.getMealMeasuredIngredientDtos().add(mealMeasuredIngredientDto);
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

		MealEntity mealEntity = mealConverter.convertToEntity(dto);

		mealRepository.saveAndFlush(mealEntity);

		mealDetailRepository.deleteAll(mealEntity.getMealDetails());
		
		for (MealMeasuredIngredientDto mmiDto : dto.getMealMeasuredIngredientDtos()) {

			MealDetailEntity mealDetailEntity = new MealDetailEntity();
			
			MeasuredIngredientEntity measuredIngredientEntity = new MeasuredIngredientEntity();
			measuredIngredientEntity.setId(mmiDto.getMeasuredIngredientId());

			mealDetailEntity.setQuantity(new BigDecimal(mmiDto.getQuantity()));
			mealDetailEntity.setMeasuredIngredient(measuredIngredientEntity);
			mealDetailEntity.setMeal(mealEntity);

			mealDetailRepository.saveAndFlush(mealDetailEntity);

		}

	}

	@Override
	public void deleteById(Integer mealId) {

		mealRepository.deleteById(mealId);

	}

}
