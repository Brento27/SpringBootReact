package com.brent.app.ws.userservice.imple;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brent.app.ws.shared.Utils;
import com.brent.app.ws.ui.models.request.UserDetailsRequestModel;
import com.brent.app.ws.ui.models.response.UserRest;
import com.brent.app.ws.userservice.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImplementation() {}
	
	@Autowired
	public UserServiceImplementation(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}

	@Override
	public Map<String, UserRest> getUsers() {
		return users;
	}
	
	

}
