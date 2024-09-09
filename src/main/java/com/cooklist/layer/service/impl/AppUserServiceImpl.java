package com.cooklist.layer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.entity.AppUserEntity;
import com.cooklist.layer.repository.AppUserRepository;
import com.cooklist.layer.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	@Qualifier("appUserConverter")
	private BeanConverter<AppUserEntity, AppUserDto> appUserConverter;

	@Override
	public AppUserDto findByEmail(String email) {

		AppUserEntity entity = appUserRepository.findByEmail(email);

		return appUserConverter.convertToDto(entity);

	}

	@Override
	public AppUserDto findByEmailWithEncryptedPassword(String email) {

		AppUserEntity entity = appUserRepository.findByEmail(email);

		AppUserDto dto = appUserConverter.convertToDto(entity);
		
		dto.setPassword(entity.getPassword());
		
		return dto;
	}

	@Override
	public AppUserDto getUserInSession() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		AppUserDto appUserDto = (AppUserDto) authentication.getPrincipal();
		
		appUserDto.setPassword(null);
		
		return appUserDto;
	}

	@Override
	public AppUserDto getUserIdInSession() {

		AppUserDto appUserDto = getUserInSession();
		
		return new AppUserDto(appUserDto.getId());
		
	}

}
