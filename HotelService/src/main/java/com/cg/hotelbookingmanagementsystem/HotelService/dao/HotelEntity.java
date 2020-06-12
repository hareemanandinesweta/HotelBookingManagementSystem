package com.cg.hotelbookingmanagementsystem.HotelService.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Hotel")
@Table(name = "Hotel")

public class HotelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotelid")
	private Integer hotelId;
	
	
	@Column(name = "city")
	@NotNull(message = "City is mandatory")
	private String city;

	@NotBlank(message = "hotel name is mandatory")
	@NotNull(message = "hotel name is mandatory")
	@Column(name = "hotelname")
	private String hotelName;
	
	
	@Size(min = 2, max = 30)
	@Column(name = "address")
	@NotBlank(message = "hotel address is mandatory")
	@NotNull(message = "hotel address is mandatory")
	private String address;
	
	@Min(2)
	@NotNull(message = "Rate cannot be null")
	@Column(name = "avgratepernight")
	private Integer avgRatePerNight;
	
	
	@Column(name = "phoneno")
	@NotBlank(message = "hotel phone no is mandatory")
	@NotNull(message = "hotel phone no is mandatory")
	private String phoneNo;
	
	@Email
	@NotBlank(message = "email id is mandatory")
	@NotNull(message = "email id is mandatory")
	@Column(name = "email")
	private String email;
	@Min(1)
	@Column(name = "rating")
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

	public HotelEntity(Integer hotelId, String city, String hotelName, String address, Integer avgRatePerNight,
			String phoneNo, String email, Integer rating) {
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

	public HotelEntity() {

	}
}