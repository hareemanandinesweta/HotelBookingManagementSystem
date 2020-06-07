package com.cg.AuthenticationService.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@Column(name= "userid" )
	private Integer userId;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="userrole")
	private String userRole;
	@Column(name="mobileno")
	private Long mobileNo;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public UserEntity(String userName, Integer userId, String userRole, String password) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userRole = userRole;
		this.password = password;
	}
	public UserEntity() {
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	}