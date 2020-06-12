package com.cg.hotelbookingmanagementsystem.HotelService.dto;


public class Hotel {

	private Integer hotelId;
	
	private String city;
	
	private String hotelName;
	
	private String address;
	private Integer avgRatePerNight;
	
	private String phoneNo;
	
	private String email;
	private Integer rating;
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAvgRatePerNight() {
		return avgRatePerNight;
	}
	public void setAvgRatePerNight(Integer avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}	
	public Hotel(Integer hotelId, String city, String hotelName, String address, Integer avgRatePerNight, String phoneNo,
			String email, Integer rating) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo = phoneNo;
		this.email = email;
		this.rating = rating;
	}
	
	public Hotel() {
		
	}
}


