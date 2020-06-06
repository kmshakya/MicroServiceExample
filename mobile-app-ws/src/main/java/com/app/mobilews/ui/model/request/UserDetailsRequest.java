package com.app.mobilews.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDetailsRequest {
	@NotNull(message="First name cannot be null")
	@Size(min=1,message="First Name cannot be empty")
	private String firstName;
	
	@NotNull(message="Last name cannot be bull")
	@Size(min=1,message="Last Name cannot be empty")
	private String lastName;
	
	@NotNull(message="Email cannot be null")
	@Email(message="Not a valid Email")
	private String email;
	
	@Size(min=8,max=16,message="Password cannot be smaller than 8 and greater than 16")
	private String password;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
