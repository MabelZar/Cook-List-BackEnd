package com.cooklist.layer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.MeasuredIngredientDto;
import com.cooklist.bean.entity.MeasuredIngredientEntity;
import com.cooklist.layer.repository.MeasuredIngredientRepository;
import com.cooklist.layer.service.MeasuredIngredientService;

@Service
public class MeasuredIngredientServiceImpl implements MeasuredIngredientService {

	@Autowired
	private MeasuredIngredientRepository measuredIngredientRepository;

	@Autowired
	@Qualifier("measuredIngredientConverter")
	private BeanConverter<MeasuredIngredientEntity, MeasuredIngredientDto> measuredIngredientConverter;

	@Override
	public List<MeasuredIngredientDto> getAll() {

		List<MeasuredIngredientEntity> entities = measuredIngredientRepository.findAll();

		return measuredIngredientConverter.convertToDtos(entities);

	}

}
