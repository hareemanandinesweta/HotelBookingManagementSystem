package com.cg.AuthenticationService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AuthenticationService.dao.UserEntity;
import com.cg.AuthenticationService.dao.UserRepository;
import com.cg.AuthenticationService.dto.User;
@Service
public class AuthorizationService {
	@Autowired
	UserRepository repository;
	//add user
	public String addCustomer(User user) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		entity.setUserName(user.getUserName());
		entity.setPassword(user.getPassword());
		entity.setUserId(user.getUserId());
		entity.setUserRole(user.getUserRole());
		entity.setAddress(user.getAddress());
		entity.setMobileNo(user.getMobileNo());
		
		repository.saveAndFlush(entity);		
		String msg = "Customer added successfully with cusId "+entity.getUserId();
		return msg;

	}
	
	public List<User> getUsers() {
		List<UserEntity> entityList=repository.findAll();
		List<User> cusList = new ArrayList<>();
		for (UserEntity entity : entityList) {
			User customer = new User();
			customer.setUserId(entity.getUserId());
			customer.setUserName(entity.getUserName());
			
			customer.setMobileNo(entity.getMobileNo());
//			customer.set(entity.getEmail());
			customer.setPassword(entity.getPassword());
			customer.setAddress(entity.getAddress());
			
			cusList.add(customer);

		}
		return cusList;
	}

}
