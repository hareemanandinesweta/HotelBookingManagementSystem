package com.cg.hotelbookingmanagementsystem.HotelService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotelbookingmanagementsystem.HotelService.dto.Hotel;
import com.cg.hotelbookingmanagementsystem.HotelService.exception.HotelNameNotFoundException;
import com.cg.hotelbookingmanagementsystem.HotelService.exception.HotelNotFoundException;
import com.cg.hotelbookingmanagementsystem.HotelService.service.HotelService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class HotelController {
	@Autowired
	
	HotelService service;
	@GetMapping("/getAllHotels")
	public List<Hotel> getAllList(){
	return service.getHotelList();
	}
	
	@GetMapping("/getHotelByName/{name}")
	public List<Hotel> getAllHotelByName(@Valid @PathVariable("name") String name ) throws HotelNameNotFoundException{
		
	return service.getHotelByName(name);
	}
	
	@GetMapping("/getHotelByID/{id}")
	public ResponseEntity<Hotel> getHotelByID(@Valid @PathVariable("id") Integer id) throws HotelNotFoundException{	
		Hotel hotel = service.getHotelById(id);
		
		return new ResponseEntity<>(hotel,HttpStatus.OK);
	}

	@PostMapping("/addHotel")
	public String addHotel(@Valid @RequestBody Hotel hotel) {
		return service.addHotel(hotel);
	}
	
	@DeleteMapping("/deleteHotel/{hotelid}")
	public String deleteHotel(@Valid @PathVariable("hotelid") Integer Id) {
		return service.deleteById(Id);
	}
	
	@PutMapping("/updateHotel/{id}")
	public String updateHotel(@Valid @RequestBody Hotel hotel,@PathVariable("id") Integer id) {
		return service.updateHotel(hotel, id);
	}
	
	@GetMapping("/getHotelByNameInOrder")
	public List<Hotel> getAllHotelByNameInOrder() throws HotelNameNotFoundException{
		
	return service.getHotelByNameInOrder();
	}	
}
