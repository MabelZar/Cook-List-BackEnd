package com.cooklist.layer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooklist.bean.entity.AppUserEntity;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
	
	AppUserEntity findByEmail(String email);

}
