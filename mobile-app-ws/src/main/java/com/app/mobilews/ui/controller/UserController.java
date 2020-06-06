package com.app.mobilews.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobilews.ui.model.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit) {
		return "get users was called page is : "+page+" limit is : "+limit;
	}
	
	@GetMapping(path="/{userId}", produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public UserRest getUser(@PathVariable String userId) {
		UserRest user=new UserRest();
		user.setFirstName("Krishna");
		user.setLastName("Shakya");
		user.setEmail("test@test.com");
		return user;
	}
	
	@PostMapping
	public String addUser() {
		return "add user was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
