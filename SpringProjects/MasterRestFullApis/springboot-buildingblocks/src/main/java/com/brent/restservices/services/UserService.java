package com.brent.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brent.restservices.entities.User;
import com.brent.restservices.exceptions.UserNotFoundException;
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
	
	//CetUserById Method
		public Optional<User> getUserById(Long id) throws UserNotFoundException {
			Optional<User> user = userRepository.findById(id);
			
			if(!user.isPresent()) {
				throw new UserNotFoundException("User not found in repository");
			}
			return user;
		}
		
	//Update User by id 
	
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in repository, provide the correct user id");
		}
		
		user.setId(id);
		return userRepository.save(user);
	}
		
	//deleteUserById
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	//getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
