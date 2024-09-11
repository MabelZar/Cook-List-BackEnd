package com.cooklist.bean.dto;

public class RegisterDto {

	private String fullName;
	
	private Integer quantityMembers;
	
	private String email;

	private String password;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Integer getQuantityMembers() {
		return quantityMembers;
	}

	public void setQuantityMembers(Integer quantityMembers) {
		this.quantityMembers = quantityMembers;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}