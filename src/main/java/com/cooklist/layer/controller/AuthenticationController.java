package com.cooklist.layer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.bean.dto.LoginDto;
import com.cooklist.bean.dto.LoginResponseDto;
import com.cooklist.bean.dto.RegisterDto;
import com.cooklist.layer.service.AuthenticationService;

@RequestMapping("/authentication")
@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<AppUserDto> register(@RequestBody RegisterDto registerDto) {

		AppUserDto appUserDto = authenticationService.register(registerDto);

		return ResponseEntity.ok(appUserDto);

	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {

		LoginResponseDto loginResponseDto = authenticationService.login(loginDto);

		return ResponseEntity.ok(loginResponseDto);

	}

}