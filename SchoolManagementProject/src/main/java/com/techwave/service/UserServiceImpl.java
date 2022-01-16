package com.techwave.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techwave.entity.User;
import com.techwave.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public Optional<User> getUserById(String userId) {
		
		return repository.findById(userId);
	}
	@Override
	public UserDetails loadUserByUsername(String userId)throws UsernameNotFoundException {
		
		Optional<User> userOptional=repository.findById(userId);
		if (userOptional.isPresent()) {
			User user=userOptional.get();
			return user;
		}
		return (UserDetails) new UsernameNotFoundException("Not found "+userId);
		
	}
	@Override
	public User createUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}
}
