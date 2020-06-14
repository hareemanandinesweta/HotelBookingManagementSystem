/****************************************************************************************************************************
 - File Name        : User
 - Author           : Reema Kumari
 - Creation Date    : 10-06-2020
 - Description      : This is an user class which contains all the validations part.
  ****************************************************************************************************************************/ 



package com.cg.hbms.userservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component   
public class User {
	
	
	private Long userId;
	
	@NotBlank(message="userName is mandatory")
	@NotNull(message="userName is mandatory")
	private String userName;
	
	@NotBlank(message="password is mandatory")
	@NotNull(message="password is mandatory")
	private String password;
	
	@NotBlank(message="role is mandatory")
	@NotNull(message="role is mandatory")
	private String role;
	
	private String mobileNo;
	
	@NotBlank(message="email is mandatory")
	@NotNull(message="email is mandatory")
	private String email;
	
	@NotBlank(message="address is mandatory")
	@NotNull(message="address is mandatory")
    private String address;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
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
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", address=" + address + "]";
	}

	
}
