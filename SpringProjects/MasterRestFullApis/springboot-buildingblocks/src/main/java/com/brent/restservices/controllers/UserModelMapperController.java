package com.brent.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brent.restservices.dtos.UserMmDto;
import com.brent.restservices.entities.User;
import com.brent.restservices.exceptions.UserNotFoundException;
import com.brent.restservices.services.UserService;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

	//Autowire the UserService
		@Autowired
		private UserService userService;
		
		@Autowired
		private ModelMapper modelMapper;
		
		//getUserById
		@GetMapping("/{id}")
		public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
			
			
				Optional<User> userOptional = userService.getUserById(id);
			
			if(!userOptional.isPresent()) {
				throw new UserNotFoundException("user not found");
			}
			
			User user = userOptional.get();
			
		UserMmDto userMmDto = modelMapper.map(user,  UserMmDto.class);
		
		return userMmDto;
		}
}
