/****************************************************************************************************************************
 - File Name        : UserEntity
 - Author           : Reema Kumari
 - Creation Date    : 10-06-2020
 - Description      : This is an Entity class of UserService which maps the instance variable with User table columns.
  ****************************************************************************************************************************/ 


package com.cg.hbms.userservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private Long userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="mobileno")
	private String mobileNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
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


	
   public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", address=" + address + "]";
	}
    
    

}


