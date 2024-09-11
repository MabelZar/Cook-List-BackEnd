package com.cooklist.layer.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cooklist.bean.converter.BeanConverter;
import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.LoginDto;
import com.cooklist.bean.dto.LoginResponseDto;
import com.cooklist.bean.dto.RegisterDto;
import com.cooklist.bean.entity.AppUserEntity;
import com.cooklist.config.JwtService;
import com.cooklist.config.exception.CockListException;
import com.cooklist.config.exception.ExceptionType;
import com.cooklist.layer.repository.AppUserRepository;
import com.cooklist.layer.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	@Qualifier("appUserConverter")
	private BeanConverter<AppUserEntity, AppUserDto> appUserConverter;

	@Override
	public AppUserDto register(RegisterDto registerDto) {

		AppUserEntity appUserEntity = new AppUserEntity();
		appUserEntity.setFullName(registerDto.getFullName());
		appUserEntity.setQuantityMembers(registerDto.getQuantityMembers());
		appUserEntity.setEmail(registerDto.getEmail());
		appUserEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		appUserRepository.save(appUserEntity);

		AppUserDto appUserDto = appUserConverter.convertToDto(appUserEntity);

		return appUserDto;

	}

	@Override
	public LoginResponseDto login(LoginDto loginDto) {

		UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
				loginDto.getPassword());

		authenticationManager.authenticate(upat);

		AppUserEntity appUserEntity = appUserRepository.findByEmail(loginDto.getEmail());

		if (Objects.isNull(appUserEntity)) {
			throw new CockListException(ExceptionType.UNAUTHORIZED, "Las credenciales no son correctas");
		}

		AppUserDto appUserDto = appUserConverter.convertToDto(appUserEntity);

		String jwtToken = jwtService.generateToken(appUserDto);

		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setToken(jwtToken);
		loginResponseDto.setExpiresIn(jwtService.getExpirationTime());

		return loginResponseDto;

	}
}