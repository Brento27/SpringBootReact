package com.brent.restservices.controllers;

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
import com.brent.restservices.entities.Views;
import com.brent.restservices.exceptions.UserNotFoundException;
import com.brent.restservices.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@Validated
@RequestMapping(value = "/jsonview/users")
public class UserJsonViewController {

	// Autowire the UserService
	@Autowired
	private UserService userService;

	// getUserById -- External
	@JsonView(Views.External.class)
	@GetMapping("/external/{id}")
	public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {

		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}

	}

	// getUserById -- Internal
	@GetMapping("/internal/{id}")
	@JsonView(Views.Internal.class)
	public Optional<User> getUserById2(@PathVariable("id") @Min(1) Long id) {

		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}

	}
}
