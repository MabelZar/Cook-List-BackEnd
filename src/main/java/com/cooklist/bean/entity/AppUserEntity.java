package com.cooklist.bean.entity;
// Generated 6 sept 2024 0:18:04 by Hibernate Tools 5.2.13.Final

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "app_user", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AppUserEntity implements java.io.Serializable {

	private static final long serialVersionUID = 2892972565198327204L;
	private Integer id;
	private String fullName;
	private Integer quantityMembers;
	private String email;
	private String password;
	private Set<MealProgrammingEntity> mealProgrammings = new HashSet<MealProgrammingEntity>(0);

	public AppUserEntity() {
	}

	public AppUserEntity(Integer id, String fullName, String email, String password) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public AppUserEntity(Integer id, String fullName, String email, String password,
			Set<MealProgrammingEntity> mealProgrammings) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.mealProgrammings = mealProgrammings;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "full_name", nullable = false, length = 100)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name= "quantity_members", nullable = false)
	public Integer getQuantityMembers() {
		return quantityMembers;
	}

	public void setQuantityMembers(Integer quantityMembers) {
		this.quantityMembers = quantityMembers;
	}

	@Column(name = "email", unique = true, nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 1000)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<MealProgrammingEntity> getMealProgrammings() {
		return this.mealProgrammings;
	}

	public void setMealProgrammings(Set<MealProgrammingEntity> mealProgrammings) {
		this.mealProgrammings = mealProgrammings;
	}

}
