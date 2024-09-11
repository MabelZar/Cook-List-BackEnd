package com.cooklist.layer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cooklist.bean.entity.MealProgrammingEntity;
import com.cooklist.bean.entity.view.IngredientSummaryView;

@Repository
public interface MealProgrammingRepository extends JpaRepository<MealProgrammingEntity, Integer> {

	String CALCULATE_INGREDIENTS_BY_MEAL_ID = "SELECT new com.cooklist.bean.entity.view.IngredientSummaryView(CAST(mi.id AS integer), CAST(i.id AS integer), i.name, CAST(mu.id AS integer), mu.name, mu.symbol, CAST(md.quantity AS double))"
			+ " FROM MealDetailEntity md"
			+ " JOIN md.meal m"
			+ " JOIN md.measuredIngredient mi"
			+ " JOIN mi.measurementUnit mu"
			+ " JOIN mi.ingredient i"
			+ " WHERE m.id = ?1";
	
	@Query(value = "select mp.id from MealProgrammingEntity as mp where mp.appUser.id = ?1 and mp.programming = ?2")
	Integer findFirstIdByData(Integer appUserId, Date programming);
	
	@Query(CALCULATE_INGREDIENTS_BY_MEAL_ID)
	List<IngredientSummaryView> calculateIngredients(Integer mealId);

}
