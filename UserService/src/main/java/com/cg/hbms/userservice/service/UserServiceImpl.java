/****************************************************************************************************************************
 - File Name        : UserServiceImpl
 - Author           : Reema Kumari
 - Creation Date    : 10-06-2020
 - Description      : This is a service class which contains the business logic of User Service.
  ****************************************************************************************************************************/ 



package com.cg.hbms.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbms.userservice.dao.UserEntity;
import com.cg.hbms.userservice.dao.UserRepository;
import com.cg.hbms.userservice.exceptions.UserNotFoundException;
import com.cg.hbms.userservice.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	
	 //To fetch all the user data
	/****************************************************************************************************************************
		 - Method Name      : viewUsers
		 - Return type      : List<User>
		 - Author           : Reema Kumari
		 - Creation Date    : 10-06-2020
		 - Description      : Method to fetch all the list of users.
		  ****************************************************************************************************************************/ 
	public List<User> viewUsers() {
		List<UserEntity> entityList=repository.findAll();
		List<User> userList = new ArrayList<>();
		for (UserEntity entity : entityList) {
			User user = new User();
			user.setUserId(entity.getUserId());
			user.setUserName(entity.getUserName());
			user.setPassword(entity.getPassword());
			user.setRole(entity.getRole());
			user.setMobileNo(entity.getMobileNo());
			user.setEmail(entity.getEmail());
			user.setAddress(entity.getAddress());
			
			userList.add(user);

		}
		return userList;
	}

	//Fetching the user data by Id
    /****************************************************************************************************************************
		 - Method Name      : viewUserById
		 - Input Parameters : userId
		 - Return type      : User
		 - Author           : Reema Kumari
		 - Creation Date    : 10-06-2020
		 - Description      : Mthod to fetch the user data by Id.
	****************************************************************************************************************************/ 
	@Override
	public User viewUserById(Long userId) throws UserNotFoundException {
		// TODO Auto-generated method stub

		Optional<UserEntity> optional = repository.findById(userId);
		if(optional.isPresent()) {
			UserEntity entity = optional.get();
			User user = new User();
			user.setUserId(entity.getUserId());
			user.setUserName(entity.getUserName());
			user.setPassword(entity.getPassword());
			user.setRole(entity.getRole());
			user.setMobileNo(entity.getMobileNo());
			user.setEmail(entity.getEmail());
			user.setAddress(entity.getAddress());
			
			return user;
		}
		else {
			throw new UserNotFoundException("User not found for the given id");
		}
	}

	
	 //Adding the user data
	/****************************************************************************************************************************
		 - Method Name      : addUser
		 - Input Parameters : user
		 - Return type      : ResponseEntity<String>
		 - Author           : Reema Kumari
		 - Creation Date    : 10-06-2020
		 - Description      : Method to add the user data into database.
		  ****************************************************************************************************************************/ 
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		entity.setUserName(user.getUserName());
		entity.setPassword(user.getPassword());
		entity.setRole(user.getRole());
		entity.setMobileNo(user.getMobileNo());
		entity.setEmail(user.getEmail());
		entity.setAddress(user.getAddress());
		
		repository.saveAndFlush(entity);		
		String msg = "User added successfully with userId "+entity.getUserId();
		return msg;

	}

	 //Updating the user data
	/****************************************************************************************************************************
		 - Method Name      : updateUser
		 - Input Parameters : userId, user
		 - Return type      : String
		 - Author           : Reema Kumari
		 - Creation Date    : 10-06-2020
		 - Description      : Method to update the user data.
	 ****************************************************************************************************************************/ 
	@Override
	public String updateUser(Long userId,User user) throws UserNotFoundException{
		
	    Optional<UserEntity> optional =	repository.findById(userId);
	    UserEntity entity = optional.get();
		entity.setUserName(user.getUserName());
		entity.setPassword(user.getPassword());
		entity.setRole(user.getRole());
		entity.setMobileNo(user.getMobileNo());
		entity.setEmail(user.getEmail());
		entity.setAddress(user.getAddress());
		
		repository.save(entity);
		return "User updated successfully!";

	}
	
	//Deleting the user data 
	/****************************************************************************************************************************
		 - Method Name      : deleteUser
		 - Input Parameters : userId
		 - Return type      : String
		 - Author           : Reema Kumari
		 - Creation Date    : 10-06-2020
		 - Description      : Method to delete the user data.
	****************************************************************************************************************************/ 

	@Override
	public String deleteUser(Long userId) throws UserNotFoundException{
		
		repository.deleteById(userId);
		return "User record deleted successfully!";


	}
}