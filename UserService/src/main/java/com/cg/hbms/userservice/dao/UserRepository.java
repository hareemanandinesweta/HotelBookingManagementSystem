/****************************************************************************************************************************
 - File Name        : UserRepository
 - Author           : Reema Kumari
 - Creation Date    : 10-06-2020
 - Description      : This is an interface for UserService which extends JpaRepository to perform all the basic CRUD Operations.
  ****************************************************************************************************************************/ 


package com.cg.hbms.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
