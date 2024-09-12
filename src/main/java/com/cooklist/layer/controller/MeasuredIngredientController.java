package com.cooklist.layer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.MeasuredIngredientDto;
import com.cooklist.layer.service.MeasuredIngredientService;

@RestController
@RequestMapping("/measured-ingredient")
public class MeasuredIngredientController {

	@Autowired
	private MeasuredIngredientService measuredIngredientService;
	
	@GetMapping("/get-all")
	public List<MeasuredIngredientDto> getAll() {
		
		return measuredIngredientService.getAll();
		
	}
}
