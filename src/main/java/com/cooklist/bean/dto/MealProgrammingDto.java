package com.cooklist.bean.dto;

import java.util.Date;

public class MealProgrammingDto implements java.io.Serializable {

	private static final long serialVersionUID = -2734768307673421317L;
	private Integer id;
	private MealDto meal;
	private AppUserDto appUser;
	private Date programming;

	public MealProgrammingDto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MealDto getMeal() {
		return this.meal;
	}

	public void setMeal(MealDto meal) {
		this.meal = meal;
	}

	public AppUserDto getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUserDto appUser) {
		this.appUser = appUser;
	}

	public Date getProgramming() {
		return this.programming;
	}

	public void setProgramming(Date programming) {
		this.programming = programming;
	}

}
