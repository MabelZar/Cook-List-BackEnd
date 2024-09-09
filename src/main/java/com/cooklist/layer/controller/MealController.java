package com.cooklist.layer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.MealDto;
import com.cooklist.layer.service.MealService;

import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/meal")
@Validated
public class MealController {

	@Autowired
	private MealService mealService;

	@GetMapping("/find-by-name/{name}")
	public List<MealDto> findByName(@PathVariable @NotBlank String name) {

		return mealService.findByName(name);
		
	}

}
