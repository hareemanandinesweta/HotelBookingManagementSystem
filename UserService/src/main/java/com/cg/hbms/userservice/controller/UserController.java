/****************************************************************************************************************************
 - File Name        : UserController
 - Author           : Reema Kumari
 - Creation Date    : 10-06-2020
 - Description      : This is an end point controller to consume the user service.
  ****************************************************************************************************************************/ 



package com.cg.hbms.userservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbms.userservice.exceptions.UserNotFoundException;
import com.cg.hbms.userservice.model.User;
import com.cg.hbms.userservice.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	//http://localhost:9090/user/viewUsers
	//To fetch all the user data
	
	/****************************************************************************************************************************
	 - Method Name      : viewUsers
	 - Return type      : ResponseEntity<List<User>>
	 - Author           : Reema Kumari
	 - Creation Date    : 10-06-2020
	 - Description      : Fetching all the user data.
	 - End point URL    : localhost:9090
	  ****************************************************************************************************************************/ 

	@GetMapping("/viewUsers")
	public ResponseEntity<List<User>> viewUsers() {
		List<User> userList=service.viewUsers();
		return new ResponseEntity<>(userList,HttpStatus.OK);
		
	}
	
	//http://localhost:9090/user/addUser
	//Adding the user data
	
	/****************************************************************************************************************************
	 - Method Name      : addUser
	 - Input Parameters : user
	 - Return type      : ResponseEntity<String>
	 - Author           : Reema Kumari
	 - Creation Date    : 10-06-2020
	 - Description      : adding the user data into database.
	 - End point URL     : localhost:9090
	  ****************************************************************************************************************************/ 
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		String msg= service.addUser(user);
		ResponseEntity<String> response = new ResponseEntity(msg, HttpStatus.ACCEPTED);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
			}
	
	//http://localhost:9090/user/viewUserById/1003
	//Fetching the user data by Id
	/****************************************************************************************************************************
	 - Method Name      : viewUserById
	 - Input Parameters : userId
	 - Return type      : ResponseEntity<User>
	 - Author           : Reema Kumari
	 - Creation Date    : 10-06-2020
	 - Description      : fetching the user data by Id.
	 - End point URL    : localhost:9090
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/viewUserById/{userId}")
	public ResponseEntity<User> viewUserById(@PathVariable("userId") Long userId) throws UserNotFoundException {
		
		User user=service.viewUserById(userId);
		return ResponseEntity.ok(user);
	}
	

	//http://localhost:9090/user/deleteUser/1003
	//Deleting the user data 
	/****************************************************************************************************************************
	 - Method Name      : deleteUser
	 - Input Parameters : userId
	 - Return type      : ResponseEntity<String>
	 - Author           : Reema Kumari
	 - Creation Date    : 10-06-2020
	 - Description      : Deleting the user data from the database.
	 - End point URL     : localhost:9090
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws UserNotFoundException{
		return ResponseEntity.ok(service.deleteUser(userId));
	}
	
	//http://localhost:9090/user/updateUser/1003
	//Updating the user data
	/****************************************************************************************************************************
	 - Method Name      : updateUser
	 - Input Parameters : userId, user
	 - Return type      : ResponseEntity<String>
	 - Author           : Reema Kumari
	 - Creation Date    : 10-06-2020
	 - Description      : Updating the user data from the database.
	 - End point URL    : localhost:9090
	  ****************************************************************************************************************************/ 
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user) throws UserNotFoundException{
		return ResponseEntity.ok(service.updateUser(userId, user));
	}
	
	

}



