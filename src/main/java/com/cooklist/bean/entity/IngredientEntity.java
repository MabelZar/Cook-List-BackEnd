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
 * Ingredient generated by hbm2java
 */
@Entity
@Table(name = "ingredient", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class IngredientEntity implements java.io.Serializable {

	private static final long serialVersionUID = -1757756090391467490L;
	private Integer id;
	private String name;
	private Set<MeasuredIngredientEntity> measuredIngredients = new HashSet<MeasuredIngredientEntity>(0);

	public IngredientEntity() {
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

	@Column(name = "name", unique = true, nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ingredient", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<MeasuredIngredientEntity> getMeasuredIngredients() {
		return this.measuredIngredients;
	}

	public void setMeasuredIngredients(Set<MeasuredIngredientEntity> measuredIngredients) {
		this.measuredIngredients = measuredIngredients;
	}

}
