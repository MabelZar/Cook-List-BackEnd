package com.cooklist.layer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooklist.bean.entity.MeasuredIngredientEntity;

public interface MeasuredIngredientRepository extends JpaRepository<MeasuredIngredientEntity, Integer> {

}
