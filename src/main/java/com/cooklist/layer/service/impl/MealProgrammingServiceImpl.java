package com.cooklist.layer.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.MealMeasuredIngredientDto;
import com.cooklist.bean.dto.MealProgrammingDto;
import com.cooklist.bean.entity.MealProgrammingEntity;
import com.cooklist.bean.entity.view.MealMeasuredIngredientView;
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

	@Autowired
	@Qualifier("mealMeasuredIngredientConverter")
	private BeanConverter<MealMeasuredIngredientView, MealMeasuredIngredientDto> mealMeasuredIngredientConverter;

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

	@Override
	public List<MealMeasuredIngredientDto> calculateIngredientsByMeals(List<Integer> mealIds) {

		Map<Integer, MealMeasuredIngredientDto> mealMeasuredIngredientDtoMap = new HashMap<Integer, MealMeasuredIngredientDto>();

		for (Integer mealId : mealIds) {

			List<MealMeasuredIngredientView> views = mealProgrammingRepository.calculateIngredients(mealId);

			for (MealMeasuredIngredientView view : views) {

				MealMeasuredIngredientDto dto = mealMeasuredIngredientDtoMap
						.getOrDefault(view.getMeasuredIngredientId(), null);

				if (Objects.isNull(dto)) {

					dto = mealMeasuredIngredientConverter.convertToDto(view);

				} else {
					dto.setQuantity(dto.getQuantity() + view.getQuantity());
				}

				mealMeasuredIngredientDtoMap.put(view.getMeasuredIngredientId(), dto);
			}

		}

		final Integer quantityMembers = appUserService.getUserInSession().getQuantityMembers();

		// LAMBDA
		return mealMeasuredIngredientDtoMap.values().stream().map(dto -> {

			BigDecimal consolidatedQuantity = new BigDecimal(dto.getQuantity() * quantityMembers).setScale(3,
					RoundingMode.HALF_UP);

			dto.setQuantity(consolidatedQuantity.doubleValue());

			return dto;

		}).toList();
	}

}
