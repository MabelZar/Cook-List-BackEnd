package com.cooklist.layer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooklist.bean.entity.MealDetailEntity;

@Repository
public interface MealDetailRepository extends JpaRepository<MealDetailEntity, Integer> {

}
