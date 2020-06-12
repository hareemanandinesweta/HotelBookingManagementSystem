package com.cg.hotelbookingmanagementsystem.HotelService.service;

import java.util.List;

import com.cg.hotelbookingmanagementsystem.HotelService.dto.Hotel;
import com.cg.hotelbookingmanagementsystem.HotelService.exception.HotelNameNotFoundException;
import com.cg.hotelbookingmanagementsystem.HotelService.exception.HotelNotFoundException;

public interface HotelServiceInterface {

	public List<Hotel> getHotelByName(String hotelname) throws HotelNameNotFoundException ;
	public List<Hotel> getHotelList();
	public Hotel getHotelById(Integer hotelId) throws HotelNotFoundException;
	public String addHotel(Hotel hotel);
	public String updateHotel(Hotel hotel, Integer id);
	public String deleteById(Integer hotelid);
	public List<Hotel> getHotelByNameInOrder() throws HotelNameNotFoundException;
}
