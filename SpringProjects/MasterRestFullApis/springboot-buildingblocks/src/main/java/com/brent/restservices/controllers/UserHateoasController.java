package com.brent.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.brent.restservices.entities.Order;
import com.brent.restservices.entities.User;
import com.brent.restservices.exceptions.UserNotFoundException;
import com.brent.restservices.repositories.UserRepository;
import com.brent.restservices.services.UserService;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping
	public CollectionModel<User> getAllUsers() throws UserNotFoundException {
	    //SelfLink
	    List<User> allUsers = userService.getAllUsers();
	    for (User user: allUsers){
	        Long userId = user.getId();
	        Link selfLink = WebMvcLinkBuilder.
	                        linkTo(this.getClass()).
	                        slash(userId).
	                        withSelfRel();
	        user.add(selfLink);
	 
	        //Relationship link with allOrders
	        CollectionModel<Order> orders =
	                WebMvcLinkBuilder.methodOn(OrderHateoasController.class).
	                getAllOrders(userId);
	        Link orderLinks = WebMvcLinkBuilder.
	                            linkTo(orders).
	                            withRel("orders");
	        user.add(orderLinks);
	    }
	    //Self link to user list
	    Link selfLinkToUserList =
	                            WebMvcLinkBuilder.
	                            linkTo(this.getClass()).
	                            withSelfRel();
	    CollectionModel<User> finalResource = CollectionModel.
	                        of(allUsers, selfLinkToUserList);
	    return finalResource;
	}
	 
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") @Min(1) Long id) {
	    try {
	        Optional<User> userOptional = userService.getUserById(id);
	        User user = userOptional.get();
	        Long userId = user.getId();
	        Link selfLink = WebMvcLinkBuilder.
	                        linkTo(this.getClass()).
	                        slash(userId).
	                        withSelfRel();
	        user.add(selfLink);
	        EntityModel<User> entityModel = EntityModel.of(user);
	        return entityModel;
	    } catch (UserNotFoundException ex) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
	    }
	}
}