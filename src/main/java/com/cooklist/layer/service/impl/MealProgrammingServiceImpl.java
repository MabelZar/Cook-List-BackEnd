package com.cooklist.layer.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.MealProgrammingDto;
import com.cooklist.bean.entity.MealProgrammingEntity;
import com.cooklist.layer.repository.MealProgrammingRepository;
import com.cooklist.layer.service.AppUserService;
import com.cooklist.layer.service.MealProgrammingService;

@Service
public class MealProgrammingServiceImpl implements MealProgrammingService {

	@Autowired
	private MealProgrammingRepository mealProgrammingRepository;
	
	@Autowired
	private AppUserService appUserService;

	@Autowired
	@Qualifier("mealProgrammingConverter")
	private BeanConverter<MealProgrammingEntity, MealProgrammingDto> mealProgrammingConverter;

	@Override
	public Integer findIdByData(MealProgrammingDto dto) {

		Integer entityId = mealProgrammingRepository.findFirstIdByData(dto.getAppUser().getId(), dto.getProgramming());

		return entityId;

	}

	@Override
	public void createOrUpdate(List<MealProgrammingDto> dtos) {
		
		AppUserDto appUserDto = appUserService.getUserIdInSession();

		for (MealProgrammingDto dto : dtos) {
			
			dto.setAppUser(appUserDto);

			Integer idFound = findIdByData(dto);

			if (Objects.nonNull(idFound)) {

				dto.setId(idFound);

			}

			MealProgrammingEntity entity = mealProgrammingConverter.convertToEntity(dto);

			mealProgrammingRepository.saveAndFlush(entity);

		}

	}

}
