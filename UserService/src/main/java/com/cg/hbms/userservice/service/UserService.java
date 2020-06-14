/****************************************************************************************************************************
 - File Name        : UserService
 - Author           : Reema Kumari
 - Creation Date    : 10-06-2020
 - Description      : This is a service interface .
  ****************************************************************************************************************************/ 



package com.cg.hbms.userservice.service;

import java.util.List;

import com.cg.hbms.userservice.exceptions.UserNotFoundException;
import com.cg.hbms.userservice.model.User;

 
public interface UserService {
	
	public List<User> viewUsers();
	public User viewUserById(Long userId) throws UserNotFoundException;
    public String addUser(User user);
	public String updateUser(Long userId, User user) throws UserNotFoundException;
	public String deleteUser(Long userId) throws UserNotFoundException;


}
