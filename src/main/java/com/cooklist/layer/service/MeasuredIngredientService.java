package com.cooklist.layer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooklist.bean.dto.MeasuredIngredientDto;

@Service
public interface MeasuredIngredientService {
	
	List<MeasuredIngredientDto> getAll();

}
