package com.cooklist.layer.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.MealDto;
import com.cooklist.bean.dto.MealMeasuredIngredientDto;
import com.cooklist.config.exception.CockListException;
import com.cooklist.config.exception.ExceptionType;
import com.cooklist.layer.service.MealService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/meal")
@Validated
public class MealController {

	@Autowired
	private MealService mealService;

	@GetMapping("/get-all")
	public List<MealDto> getAll() {

		return mealService.getAll();

	}

	@GetMapping("/find-by-id/{mealId}")
	public MealDto findById(@PathVariable @NotNull Integer mealId) {

		return mealService.findById(mealId);

	}

	@GetMapping("/find-by-name/{name}")
	public List<MealDto> findByName(@PathVariable @NotBlank String name) {

		return mealService.findByName(name);

	}

	@PostMapping("/create-or-update")
	public ResponseEntity<String> createOrUpdate(@RequestBody @NotNull MealDto dto) {

		if (CollectionUtils.isNotEmpty(dto.getMealMeasuredIngredientDtos()) && StringUtils.isNotBlank(dto.getName())) {
			Set<Integer> measuredIngredientIds = new HashSet<Integer>();
			for (MealMeasuredIngredientDto mmiDto : dto.getMealMeasuredIngredientDtos()) {
				if (ObjectUtils.anyNull(mmiDto.getMeasuredIngredientId(), mmiDto.getQuantity()) || measuredIngredientIds.contains(mmiDto.getMeasuredIngredientId())) {
					throw new CockListException(ExceptionType.VALIDATION, "los datos de la comida son inválidos");
				}
				measuredIngredientIds.add(mmiDto.getMeasuredIngredientId());
			}
		} else {
			throw new CockListException(ExceptionType.VALIDATION, "los datos de la comida son inválidos");
		}

		mealService.createOrUpdate(dto);

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@DeleteMapping("/delete-by-id/{mealId}")
	public ResponseEntity<String> deleteById(@PathVariable @NotNull Integer mealId) {

		mealService.deleteById(mealId);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
