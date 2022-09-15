package com.brent.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brent.restservices.entities.User;
import com.brent.restservices.repositories.UserRepository;

//Service
@Service
public class UserService {

	//Autowire the UserRepository
	@Autowired
	private UserRepository userRepository;
	
	//getAllUsers
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
		
	}
	
	//CreateUser Method
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
}
