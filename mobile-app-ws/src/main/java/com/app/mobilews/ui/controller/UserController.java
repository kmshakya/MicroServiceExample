package com.app.mobilews.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobilews.exceptions.UserServiceException;
import com.app.mobilews.ui.model.request.UpdateUserDetailsRequest;
import com.app.mobilews.ui.model.request.UserDetailsRequest;
import com.app.mobilews.ui.model.response.UserRestResponse;

@RestController
@RequestMapping("users")
public class UserController {
	private Map<String,UserRestResponse> users=null;

	@GetMapping
	public String getUsers(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit) {
		return "get users was called page is : "+page+" limit is : "+limit;
	}
	
	@GetMapping(path="/{userId}", produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRestResponse> getUser(@PathVariable String userId) {
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
		
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRestResponse> addUser(@Valid @RequestBody UserDetailsRequest user) {
		String userId=UUID.randomUUID().toString();
		UserRestResponse userDetails=new UserRestResponse();
		
		userDetails.setFirstName(user.getFirstName());
		userDetails.setLastName(user.getLastName());
		userDetails.setEmail(user.getEmail());
		userDetails.setUserId(userId);

		if(users==null) users=new HashMap<>();
		users.put(userId, userDetails);
		
		return new ResponseEntity<UserRestResponse>(userDetails,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{userId}",consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRestResponse> updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequest updatedUserDetails) {
		
			UserRestResponse storedUser=users.get(userId);
			storedUser.setFirstName(updatedUserDetails.getFirstName());
			storedUser.setLastName(updatedUserDetails.getLastName());
			users.put(userId, storedUser);
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		
	}
	
	@DeleteMapping(path= "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		if(true) throw new UserServiceException("User Service Exception");
		users.remove(userId);	
		return ResponseEntity.noContent().build();
	}
}
