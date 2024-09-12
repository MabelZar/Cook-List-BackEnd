package com.cooklist.bean.dto;

public class LoginResponseDto {

	private String token;

	private long expiresIn;

	public String getToken() {
		return token;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setToken(String token) {
		this.token = token;
	}

}