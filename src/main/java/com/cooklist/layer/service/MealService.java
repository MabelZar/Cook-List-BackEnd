package com.cooklist.layer.service;

import java.util.List;

import com.cooklist.bean.dto.MealDto;

public interface MealService {

	List<MealDto> getAll();

	List<MealDto> findByName(String name);

	MealDto findById(Integer mealId);

	void createOrUpdate(MealDto dto);
	
	void deleteById(Integer mealId);

}
