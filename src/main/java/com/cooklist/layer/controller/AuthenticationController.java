package com.cooklist.layer.controller;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.LoginDto;
import com.cooklist.bean.dto.LoginResponseDto;
import com.cooklist.bean.dto.RegisterDto;
import com.cooklist.config.exception.CockListException;
import com.cooklist.config.exception.ExceptionType;
import com.cooklist.layer.service.AuthenticationService;

import jakarta.validation.constraints.NotNull;

@RequestMapping("/authentication")
@RestController
@Validated
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<AppUserDto> register(@RequestBody @NotNull RegisterDto registerDto) {

		if (StringUtils.isAnyBlank(registerDto.getEmail(), registerDto.getFullName(), registerDto.getPassword())
				|| Objects.isNull(registerDto.getQuantityMembers())) {

			throw new CockListException(ExceptionType.VALIDATION, "los datos del usuario no son válidos");

		}

		AppUserDto appUserDto = authenticationService.register(registerDto);

		return ResponseEntity.ok(appUserDto);

	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody @NotNull LoginDto loginDto) {

		if (StringUtils.isAnyBlank(loginDto.getEmail(), loginDto.getPassword())) {

			throw new CockListException(ExceptionType.VALIDATION, "los datos del inicio de sesión no son válidos");

		}

		LoginResponseDto loginResponseDto = authenticationService.login(loginDto);

		return ResponseEntity.ok(loginResponseDto);

	}

}