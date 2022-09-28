package com.brent.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brent.restservices.entities.Order;
import com.brent.restservices.entities.User;
import com.brent.restservices.exceptions.UserNotFoundException;
import com.brent.restservices.repositories.OrderRepository;
import com.brent.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/hateoas/users")
public class OrderHateoasController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	OrderRepository orderRepository;
	
	//get All Orders for a user
		@GetMapping("/{userid}/orders")
		public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
			
			Optional<User> userOptional = userRepository.findById(userid);
			if(!userOptional.isPresent()) {
				throw new UserNotFoundException("User Not Found");
			}
			
			return userOptional.get().getOrders();
			
		}
}
