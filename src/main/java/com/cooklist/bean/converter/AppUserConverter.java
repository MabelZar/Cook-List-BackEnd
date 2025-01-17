package com.cooklist.bean.converter;

import org.springframework.stereotype.Component;

import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.entity.AppUserEntity;

@Component("appUserConverter")
public class AppUserConverter extends BeanConverterImpl<AppUserEntity, AppUserDto> {

	@Override
	protected void populateDto(AppUserDto dto, AppUserEntity entity) {

		dto.setId(entity.getId());
		dto.setFullName(entity.getFullName());
		dto.setQuantityMembers(entity.getQuantityMembers());
		dto.setEmail(entity.getEmail());
		
	}

	@Override
	protected void populateEntity(AppUserEntity entity, AppUserDto dto) {
		
		entity.setId(dto.getId());
		entity.setFullName(dto.getFullName());
		entity.setQuantityMembers(dto.getQuantityMembers());
		entity.setEmail(dto.getEmail());
		
	}

	@Override
	protected AppUserDto getNewDto() {
		return new AppUserDto();
	}

	@Override
	protected AppUserEntity getNewEntity() {
		return new AppUserEntity();
	}

}
