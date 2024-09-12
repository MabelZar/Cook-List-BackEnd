package com.cooklist.bean.converter;

import org.springframework.stereotype.Component;

import com.cooklist.bean.dto.MeasurementUnitDto;
import com.cooklist.bean.entity.MeasurementUnitEntity;

@Component("measurementUnitConverter")
public class MeasurementUnitConverter extends BeanConverterImpl<MeasurementUnitEntity, MeasurementUnitDto> {

	@Override
	protected void populateDto(MeasurementUnitDto dto, MeasurementUnitEntity entity) {

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSymbol(entity.getSymbol());
		dto.setIsMeasurable(entity.isIsMeasurable());

	}

	@Override
	protected void populateEntity(MeasurementUnitEntity entity, MeasurementUnitDto dto) {

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSymbol(dto.getSymbol());
		entity.setIsMeasurable(dto.isIsMeasurable());

	}

	@Override
	protected MeasurementUnitDto getNewDto() {
		return new MeasurementUnitDto();
	}

	@Override
	protected MeasurementUnitEntity getNewEntity() {
		return new MeasurementUnitEntity();
	}

}
