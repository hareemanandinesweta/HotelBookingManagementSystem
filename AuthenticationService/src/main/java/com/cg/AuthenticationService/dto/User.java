package com.cg.AuthenticationService.dto;

public class User {

	private String userName;
	private Integer userId;
	private String userRole;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public User(String userName, Integer userId, String userRole) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userRole = userRole;
	}
	
}

