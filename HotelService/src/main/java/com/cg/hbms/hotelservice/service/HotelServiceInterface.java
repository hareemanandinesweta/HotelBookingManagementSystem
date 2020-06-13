package com.cg.hbms.hotelservice.service;

import java.util.List;

import com.cg.hbms.hotelservice.dto.Hotel;
import com.cg.hbms.hotelservice.exception.HotelNameNotFoundException;
import com.cg.hbms.hotelservice.exception.HotelNotFoundException;

public interface HotelServiceInterface {

	public abstract List<Hotel> getHotelByName(String hotelname) throws HotelNameNotFoundException ;
	public abstract List<Hotel> getHotelList();
	public abstract Hotel getHotelById(Integer hotelId) throws HotelNotFoundException;
	public abstract String addHotel(Hotel hotel);
	public abstract String updateHotel(Hotel hotel, Integer id);
	public abstract String deleteById(Integer hotelid);
	public abstract List<Hotel> getHotelByNameInOrder() throws HotelNameNotFoundException;
}
