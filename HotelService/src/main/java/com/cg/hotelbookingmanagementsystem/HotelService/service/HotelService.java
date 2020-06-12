package com.cg.hotelbookingmanagementsystem.HotelService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.hotelbookingmanagementsystem.HotelService.dao.HotelEntity;
import com.cg.hotelbookingmanagementsystem.HotelService.dao.HotelRepository;
import com.cg.hotelbookingmanagementsystem.HotelService.dto.Hotel;
import com.cg.hotelbookingmanagementsystem.HotelService.exception.HotelNameNotFoundException;
import com.cg.hotelbookingmanagementsystem.HotelService.exception.HotelNotFoundException;

@Service
public class HotelService {
		
	@Autowired
	HotelRepository repository;
	
	public List<Hotel> getHotelList(){
	List<HotelEntity> entity = repository.findAll();
	List<Hotel> hotelList = new ArrayList<>();
	
	for(HotelEntity hotelEntity : entity) {
		
		Hotel hotel = new Hotel();
		hotel.setAddress(hotelEntity.getAddress());
		hotel.setAvgRatePerNight(hotelEntity.getAvgRatePerNight());
		hotel.setCity(hotelEntity.getCity());
		hotel.setEmail(hotelEntity.getEmail());
		hotel.setHotelId(hotelEntity.getHotelId());
		hotel.setHotelName(hotelEntity.getHotelName());
		hotel.setPhoneNo(hotelEntity.getPhoneNo());
		hotel.setRating(hotelEntity.getRating());
		
		hotelList.add(hotel);
		}
	return hotelList;
		
	}
	
	public List<Hotel> getHotelByName(String hotelname) throws HotelNameNotFoundException{
		List<HotelEntity> entityList = repository.findByName(hotelname);
		if(entityList.size()>0) {
		List<Hotel> hotelList = new ArrayList<>();
			for(HotelEntity hotelEntity:entityList) {
				Hotel hotel = new Hotel();
				hotel.setAddress(hotelEntity.getAddress());
				hotel.setAvgRatePerNight(hotelEntity.getAvgRatePerNight());
				hotel.setCity(hotelEntity.getCity());
				hotel.setEmail(hotelEntity.getEmail());
				hotel.setHotelId(hotelEntity.getHotelId());
				hotel.setHotelName(hotelEntity.getHotelName());
				hotel.setPhoneNo(hotelEntity.getPhoneNo());
				hotel.setRating(hotelEntity.getRating());
				hotelList.add(hotel);
			}
			
			return hotelList;
		}
		else {
			throw new HotelNameNotFoundException("No Hotel with "+hotelname+" name is found");
		}
	}
	public Hotel getHotelById(Integer hotelId) throws HotelNotFoundException{
		Optional<HotelEntity> optional = repository.findById(hotelId);
		if(optional.isPresent()) {
		HotelEntity hotelEntity = optional.get();
		Hotel hotel = new Hotel();
		hotel.setAddress(hotelEntity.getAddress());
		hotel.setAvgRatePerNight(hotelEntity.getAvgRatePerNight());
		hotel.setCity(hotelEntity.getCity());
		hotel.setEmail(hotelEntity.getEmail());
		hotel.setHotelId(hotelEntity.getHotelId());
		hotel.setHotelName(hotelEntity.getHotelName());
		hotel.setPhoneNo(hotelEntity.getPhoneNo());
		hotel.setRating(hotelEntity.getRating());
		return hotel;
		}
		else {
			throw new HotelNotFoundException("no hotel found with "+hotelId+" Id.");
		}
		
	}
	
	public String addHotel(Hotel hotel) {
		
		HotelEntity newEntity = new HotelEntity();
		newEntity.setAddress(hotel.getAddress());
		newEntity.setAvgRatePerNight(hotel.getAvgRatePerNight());
		newEntity.setCity(hotel.getCity());
		newEntity.setEmail(hotel.getEmail());
		newEntity.setHotelId(hotel.getHotelId());
		newEntity.setHotelName(hotel.getHotelName());
		newEntity.setPhoneNo(hotel.getPhoneNo());
		newEntity.setRating(hotel.getRating());
		
		repository.saveAndFlush(newEntity);
		return "Hotel Added Successfully";
	}
	
	public String updateHotel(Hotel hotel, Integer id)
	{
		Optional<HotelEntity> optional = repository.findById(id);
		if(optional.isPresent()) {
			HotelEntity newEntity = optional.get();
			newEntity.setAddress(hotel.getAddress());
			newEntity.setAvgRatePerNight(hotel.getAvgRatePerNight());
			newEntity.setCity(hotel.getCity());
			newEntity.setEmail(hotel.getEmail());
			
			newEntity.setHotelName(hotel.getHotelName());
			newEntity.setPhoneNo(hotel.getPhoneNo());
			newEntity.setRating(hotel.getRating());
			
			repository.saveAndFlush(newEntity);
			
		}
		return "Hotel updated Successfully";
	}
	
	public String deleteById(Integer hotelid) {
		
		Optional<HotelEntity> optional = repository.findById(hotelid);
		
		if(optional.isPresent()) {
		HotelEntity entity = optional.get();
		repository.delete(entity);
		return "Hotel Deleted successfully";
		}
		else {
			return "Hotel with "+hotelid +" can not be found";
		}
	}
	
	public List<Hotel> getHotelByNameInOrder() throws HotelNameNotFoundException{
		List<HotelEntity> entityList = repository.findByNameAsc();
		if(entityList.size()>0) {
			
		List<Hotel> hotelList = new ArrayList<>();
			for(HotelEntity hotelEntity:entityList) {
				Hotel hotel = new Hotel();
				hotel.setAddress(hotelEntity.getAddress());
				hotel.setAvgRatePerNight(hotelEntity.getAvgRatePerNight());
				hotel.setCity(hotelEntity.getCity());
				hotel.setEmail(hotelEntity.getEmail());
				hotel.setHotelId(hotelEntity.getHotelId());
				hotel.setHotelName(hotelEntity.getHotelName());
				hotel.setPhoneNo(hotelEntity.getPhoneNo());
				hotel.setRating(hotelEntity.getRating());
				hotelList.add(hotel);
			}
			
			return hotelList;
		}
		else return null;
	
	}
}
