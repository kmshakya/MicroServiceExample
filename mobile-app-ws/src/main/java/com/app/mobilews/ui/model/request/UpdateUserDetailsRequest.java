package com.app.mobilews.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequest {
	@NotNull(message="First name cannot be null")
	@Size(min=1,message="First Name cannot be empty")
	private String firstName;
	
	@NotNull(message="Last name cannot be bull")
	@Size(min=1,message="Last Name cannot be empty")
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
