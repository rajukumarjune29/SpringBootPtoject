package com.techwave.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.entity.User;
import com.techwave.service.IUserService;

@RestController

public class UserController {

	@Autowired
	private IUserService service;
	User u1=null;
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId")String userId){
		Optional<User> user=service.getUserById(userId);
		if(user.isPresent()) {
			 u1=user.get();
		}
		//System.out.println(u1);
		return ResponseEntity.ok(u1);
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.createUser(user);
		
	}
}
