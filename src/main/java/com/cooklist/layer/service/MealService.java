package com.cooklist.layer.service;

import java.util.List;

import com.cooklist.bean.dto.MealDto;

public interface MealService {

	List<MealDto> findByName(String name);

}
