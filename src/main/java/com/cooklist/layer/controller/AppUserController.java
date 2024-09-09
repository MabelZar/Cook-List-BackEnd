package com.cooklist.layer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooklist.bean.dto.AppUserDto;
import com.cooklist.layer.service.AppUserService;

@RestController
@RequestMapping("/app-user")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;

	@GetMapping("/get-me")
	public AppUserDto getMe() {

		return appUserService.getUserInSession();

	}

}
