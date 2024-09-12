package com.cooklist.layer.service;

import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.LoginDto;
import com.cooklist.bean.dto.LoginResponseDto;
import com.cooklist.bean.dto.RegisterDto;

public interface AuthenticationService {

	AppUserDto register(RegisterDto registerDto);

	LoginResponseDto login(LoginDto loginDto);

}
