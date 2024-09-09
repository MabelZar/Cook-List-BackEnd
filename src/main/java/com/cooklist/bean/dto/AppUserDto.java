package com.cooklist.bean.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserDto implements java.io.Serializable, UserDetails {

	private static final long serialVersionUID = 3533274399641218950L;
	private Integer id;
	private String fullName;
	private String email;
	private String password;

	public AppUserDto() {
	}
	
	public AppUserDto(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of();

	}

	@Override
	public String getUsername() {
		return email;
	}

}
