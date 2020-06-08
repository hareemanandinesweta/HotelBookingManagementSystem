package com.cg.AuthenticationService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByUserName(String user);
	

}
