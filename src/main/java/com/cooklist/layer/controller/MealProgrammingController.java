package com.cooklist.layer.controller;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.MealMeasuredIngredientDto;
import com.cooklist.bean.dto.MealProgrammingDto;
import com.cooklist.config.exception.CockListException;
import com.cooklist.config.exception.ExceptionType;
import com.cooklist.layer.service.MealProgrammingService;

import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/meal-programming")
@Validated
public class MealProgrammingController {

	@Autowired
	private MealProgrammingService mealProgrammingService;

	@PostMapping("/create-or-update")
	public ResponseEntity<String> createOrUpdate(@RequestBody @NotEmpty List<MealProgrammingDto> dtos) {

		for (MealProgrammingDto dto : dtos) {

			if (ObjectUtils.anyNull(dto, dto.getProgramming())) {

				throw new CockListException(ExceptionType.VALIDATION, "las fechas no deben ser nulas");

			}

		}

		mealProgrammingService.createOrUpdate(dtos);

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PostMapping("/calculate-ingredients-by-meals")
	public List<MealMeasuredIngredientDto> calculateIngredientsByMeals(@RequestBody @NotEmpty List<Integer> mealIds) {

		for (Integer mealId : mealIds) {

			if (Objects.isNull(mealId)) {

				throw new CockListException(ExceptionType.VALIDATION, "la comida no debe ser nula");

			}

		}

		return mealProgrammingService.calculateIngredientsByMeals(mealIds);
	}

}
