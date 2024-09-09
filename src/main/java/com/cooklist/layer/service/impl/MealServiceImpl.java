package com.cooklist.layer.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.MealDto;
import com.cooklist.bean.entity.MealEntity;
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
	public List<MealDto> findByName(String name) {

		String nameLowerCase = StringUtils.lowerCase(name);

		List<MealEntity> entities = mealRepository.findByName(nameLowerCase);

		return mealConverter.convertToDtos(entities);

	}

}
