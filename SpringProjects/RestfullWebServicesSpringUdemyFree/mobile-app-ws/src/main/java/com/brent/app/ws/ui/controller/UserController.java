package com.brent.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false ) String sort) {
		return "Get Users Was Called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}")
	public String getUser(@PathVariable String userId) {
		return "Get Users Was Called with userId = " + userId;
	}

	@PostMapping
	public String createUser() {
		return "Create users was called";
	}

	@PutMapping
	public String updateUser() {
		return "update users was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete users was called";
	}
}
