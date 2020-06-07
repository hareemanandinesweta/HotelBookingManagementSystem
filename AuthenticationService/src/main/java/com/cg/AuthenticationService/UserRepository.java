package com.cg.AuthenticationService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.cg.AuthenticationService.dao.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByUserName(String user);
	

}
