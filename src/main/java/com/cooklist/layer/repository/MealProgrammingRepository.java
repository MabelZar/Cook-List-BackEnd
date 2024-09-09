package com.cooklist.layer.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cooklist.bean.entity.MealProgrammingEntity;

@Repository
public interface MealProgrammingRepository extends JpaRepository<MealProgrammingEntity, Integer> {

	@Query(value = "select mp.id from MealProgrammingEntity as mp where mp.appUser.id = ?1 and mp.programming = ?2")
	Integer findFirstIdByData(Integer appUserId, Date programming);

}
