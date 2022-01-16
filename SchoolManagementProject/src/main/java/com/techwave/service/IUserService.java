package com.techwave.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.techwave.entity.User;

public interface IUserService extends UserDetailsService {
	
	public Optional<User> getUserById(String userId);

	public User createUser(User user);

}
