package com.sofra.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sofra.demo.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
	public User findByUsername(String username);
	

}
