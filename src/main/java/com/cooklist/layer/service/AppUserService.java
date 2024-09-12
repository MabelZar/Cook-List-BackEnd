package com.cooklist.layer.service;

import com.cooklist.bean.dto.AppUserDto;

public interface AppUserService {
	
	AppUserDto findByEmail(String email);
	
	AppUserDto findByEmailWithEncryptedPassword(String email);

	AppUserDto getUserInSession();
	
	AppUserDto getUserIdInSession();
	
}
