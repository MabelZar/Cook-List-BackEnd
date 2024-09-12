package com.cooklist.layer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cooklist.bean.entity.MealEntity;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Integer> {

	@Query(value = "select m.id, m.name from meal as m where lower(m.name) like concat('%', ?1, '%')", nativeQuery = true)
	List<MealEntity> findByName(String name);

}
