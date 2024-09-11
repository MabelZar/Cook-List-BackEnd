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
import com.cooklist.bean.dto.ConsolidatedIngredientSummaryDto;
import com.cooklist.bean.dto.MealProgrammingDto;
import com.cooklist.bean.entity.MealProgrammingEntity;
import com.cooklist.bean.entity.view.IngredientSummaryView;
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

	@Override
	public List<ConsolidatedIngredientSummaryDto> calculateIngredientsByMeals(List<Integer> mealIds) {

		Map<Integer, ConsolidatedIngredientSummaryDto> consolidatedIngredientSummary = new HashMap<Integer, ConsolidatedIngredientSummaryDto>();

		for (Integer mealId : mealIds) {

			List<IngredientSummaryView> views = mealProgrammingRepository.calculateIngredients(mealId);

			for (IngredientSummaryView view : views) {

				ConsolidatedIngredientSummaryDto dto = consolidatedIngredientSummary
						.getOrDefault(view.getMeasuredIngredientId(), null);

				if (Objects.isNull(dto)) {

					dto = new ConsolidatedIngredientSummaryDto();
					dto.setMeasuredIngredientId(view.getMeasuredIngredientId());
					dto.setIngredientId(view.getIngredientId());
					dto.setIngredientName(view.getIngredientName());
					dto.setMeasurementUnitId(view.getMeasurementUnitId());
					dto.setMeasurementUnitName(view.getMeasurementUnitName());
					dto.setMeasurementUnitSymbol(view.getMeasurementUnitSymbol());
					dto.setQuantity(view.getQuantity());

				} else {
					dto.setQuantity(dto.getQuantity() + view.getQuantity());
				}

				consolidatedIngredientSummary.put(view.getMeasuredIngredientId(), dto);
			}

		}

		final Integer quantityMembers = appUserService.getUserInSession().getQuantityMembers();

		// LAMBDA
		return consolidatedIngredientSummary.values().stream().map(summary -> {

			BigDecimal consolidatedQuantity = new BigDecimal(summary.getQuantity() * quantityMembers).setScale(3, RoundingMode.HALF_UP);

			summary.setQuantity(consolidatedQuantity.doubleValue());
			
			return summary;

		}).toList();
	}

}
