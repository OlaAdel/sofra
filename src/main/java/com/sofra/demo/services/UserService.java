package com.sofra.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofra.demo.dao.UserRepository;
import com.sofra.demo.entities.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	
	
	
	

}
