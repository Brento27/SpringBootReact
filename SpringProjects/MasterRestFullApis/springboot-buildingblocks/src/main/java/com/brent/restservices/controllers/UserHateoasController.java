package com.brent.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.brent.restservices.entities.User;
import com.brent.restservices.exceptions.UserNotFoundException;
import com.brent.restservices.repositories.UserRepository;
import com.brent.restservices.services.UserService;

@RestController
@RequestMapping(value="/hateoas/users")
@Validated
public class UserHateoasController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	//getAllUsers Method
		@GetMapping()
		public List<User> getAllUsers(){
			return userService.getAllUsers();
		}
		
		//getUserById
		@GetMapping("/{id}")
		public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
			
			try {
				return userService.getUserById(id);
			} catch(UserNotFoundException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
			}
			
		}
}
