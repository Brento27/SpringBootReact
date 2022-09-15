package com.brent.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brent.restservices.entities.User;
import com.brent.restservices.services.UserService;

//Controller
@RestController
public class UserController {
	
	//Autowire the UserService
	@Autowired
	private UserService userService;
	
	//getAllUsers Method
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//Create User
	//@RequestBody Annotation
	//@PostMapping Annotation
	@PostMapping("/users")
		public User createUser(@RequestBody User user) {
			return userService.createUser(user);
		}

}
