package com.cooklist.layer.service;

import java.util.List;

import com.cooklist.bean.dto.MealMeasuredIngredientDto;
import com.cooklist.bean.dto.MealProgrammingDto;

public interface MealProgrammingService {

	Integer findIdByData(MealProgrammingDto dto);

	void createOrUpdate(List<MealProgrammingDto> dtos);

	List<MealMeasuredIngredientDto> calculateIngredientsByMeals(List<Integer> mealIds);

}
