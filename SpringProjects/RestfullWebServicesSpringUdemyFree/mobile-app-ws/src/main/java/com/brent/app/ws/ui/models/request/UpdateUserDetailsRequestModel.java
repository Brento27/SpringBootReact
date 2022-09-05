package com.brent.app.ws.ui.models.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message = "First name cannot be null")
	@Size(min = 2, message = "First name must not be less than two characters")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min = 2, message = "Lasr name must not be less than two characters")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
