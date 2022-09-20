package com.brent.restservices.exceptions;

public class UserExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1696612883759940345L;

	public UserExistsException(String message) {
		super(message);
	}
}
