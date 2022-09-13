package com.brent.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {

	
	//Simple Method
	//URI - /helloworld
	//GET
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	//Simple Method
	//URI - /helloworld
	//GET 
	@RequestMapping(method = RequestMethod.GET, path = "/helloworld1")
	public String helloWorld1() {
		return "Hello World1";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Brent", "Lombaard", "Kuruman");
	}
}
