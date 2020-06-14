package com.cg.hbms.hotelservice.service;

import java.util.List;

import com.cg.hbms.hotelservice.dto.Hotel;
import com.cg.hbms.hotelservice.exception.HotelNameNotFoundException;
import com.cg.hbms.hotelservice.exception.HotelNotFoundException;

public interface HotelServiceInterface {

	public abstract List<Hotel> getHotelByName(String hotelname) throws HotelNameNotFoundException ;
	public abstract List<Hotel> getHotelList() throws HotelNotFoundException;
	public abstract Hotel getHotelById(Integer hotelId) throws HotelNotFoundException;
	public abstract String addHotel(Hotel hotel) throws HotelNotFoundException;
	public String updateHotelNameById(Integer hotelId, String City) throws HotelNotFoundException;
	public abstract String deleteById(Integer hotelid)throws HotelNotFoundException ;
	public abstract List<Hotel> getHotelByNameInOrder() throws HotelNameNotFoundException;
	public String updateHotelPhoneNoById(Integer hotelId, String phoneNo) throws HotelNotFoundException;
	public String updateHotelCityById(Integer hotelId, String City) throws HotelNotFoundException;
}
