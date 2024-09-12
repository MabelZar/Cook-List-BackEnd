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
 * Meal generated by hbm2java
 */
@Entity
@Table(name = "meal", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class MealEntity implements java.io.Serializable {

	private static final long serialVersionUID = 3679750188093377617L;
	private Integer id;
	private String name;
	private Set<MealDetailEntity> mealDetails = new HashSet<MealDetailEntity>(0);
	private Set<MealProgrammingEntity> mealProgrammings = new HashSet<MealProgrammingEntity>(0);

	public MealEntity() {
	}

	public MealEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public MealEntity(Integer id, String name, Set<MealDetailEntity> mealDetails, Set<MealProgrammingEntity> mealProgrammings) {
		this.id = id;
		this.name = name;
		this.mealDetails = mealDetails;
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

	@Column(name = "name", unique = true, nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "meal", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<MealDetailEntity> getMealDetails() {
		return this.mealDetails;
	}

	public void setMealDetails(Set<MealDetailEntity> mealDetails) {
		this.mealDetails = mealDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "meal", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<MealProgrammingEntity> getMealProgrammings() {
		return this.mealProgrammings;
	}

	public void setMealProgrammings(Set<MealProgrammingEntity> mealProgrammings) {
		this.mealProgrammings = mealProgrammings;
	}

}
