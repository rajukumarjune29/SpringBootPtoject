package com.techwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwave.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
	

}
