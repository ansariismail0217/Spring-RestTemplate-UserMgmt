package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	boolean existsByEmail(String email);
	boolean existsByMobNum(Long mobNum);

}
