/****************************************************************************************************************************
 - File Name      	: HotelController
 - Author           : Dinesh Sharma
 - Creation Date    : 10-06-2020
 - Description      : This is an endpoint controller to consumer hotel services.
  ****************************************************************************************************************************/ 

package com.cg.hbms.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbms.hotelservice.dto.Hotel;
import com.cg.hbms.hotelservice.exception.HotelNameNotFoundException;
import com.cg.hbms.hotelservice.exception.HotelNotFoundException;

import com.cg.hbms.hotelservice.service.HotelServiceInterface;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
public class HotelController {
	@Autowired
	private HotelServiceInterface service;
	
	public boolean isRepositoryNotNull() {
		boolean flag = false;

		if (service != null) {
			flag = true;
			
		}
		return flag;
	}		
			
	/******************************************
	 - Method Name      : updatehoteCityById
	 - Input Parameters :  String City, Integer hotelId
	 - Return type      : ResponseEntity<String>
	 - Author           : Dinesh Sharma
	 - Creation Date    : 13-06-2020
	 - Description      : Updating city of existing Hotel city name in database.
	 - End Point URL    : http://localhost:8183/updateHotelCity/{hotelId}/{city}
	******************************************/ 	
		@PutMapping("/updateHotelCity/{hotelId}/{city}")
		public ResponseEntity<String> updatehoteCityById
		(@PathVariable("hotelId") Integer hotelId, @PathVariable("city") String city) throws HotelNotFoundException {
			return ResponseEntity.ok(service.updateHotelCityById(hotelId, city));
		}
	/****************************************************************************************************************************
	 - Method Name      : getAllList
	 - Return type      : List<Hotel>
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to fetch all hotel details
	 - EndPoint URL		: http://localhost:8183/getAllHotels
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getAllHotels")
	public List<Hotel> getAllList() throws HotelNotFoundException {
		return service.getHotelList();
	}
	/****************************************************************************************************************************
	 - Method Name      : getAllHotelByName
	 - Input Parameters : String name
	 - Return type      : List<Hotel>
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to fetch hotel details of a particular hotel name.
	 - EndPoint URL		: //http://localhost:8183/getHotelByName/{name}
	  ****************************************************************************************************************************/ 
	//
	@GetMapping("/getHotelByName/{name}")
	public List<Hotel> getAllHotelByName( @PathVariable("name") String name) throws HotelNameNotFoundException {
		return service.getHotelByName(name);
	}
	/****************************************************************************************************************************
	 - Method Name      : getHotelByID
	 - Input Parameters : Integer Id
	 - Return type      : ResponseEntity<Hotel>
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to fetch hotel details by providing particular ID
	 - EndPoint URL		: http://localhost:8183/getHotelByID/{id}
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getHotelByID/{id}")
	public ResponseEntity<Hotel> getHotelByID(@PathVariable("id") Integer id) throws HotelNotFoundException {
		Hotel hotel = service.getHotelById(id);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
	/****************************************************************************************************************************
	 - Method Name      : addHotel
	 - Return type      : String
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to add a new hotel in database.
	 - EndPoint URL		: http://localhost:8183/addHotel
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/addHotel")
	public String addHotel(@RequestBody Hotel hotel) throws HotelNotFoundException {
		return service.addHotel(hotel);
	}
	/****************************************************************************************************************************
	 - Method Name      : deleteHotel
	 - Input Parameters : Integer id
	 - Return type      : String
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to delete a hotel with a particular ID from database.
	 - EndPoint URL		: http://localhost:8183/deleteHotel/{hotelid}
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("/deleteHotel/{hotelid}")
	public String deleteHotel(@PathVariable("hotelid") Integer Id) throws HotelNotFoundException {
		return service.deleteById(Id);
	}
	/****************************************************************************************************************************
	 - Method Name      : updatehotelNameById
	 - Input Parameters : Hotel hotel, Integer id
	 - Return type      : String
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to update a hotel Name based on its ID.
	 - EndPoint URL		: http://localhost:8183/updateHotelName/{hotelId}/{hotelName}
	  ****************************************************************************************************************************/ 
	
	@PutMapping("/updateHotelName/{hotelId}/{hotelName}")
	public ResponseEntity<String> updatehotelNameById
	(@PathVariable("hotelId") Integer hotelId, @PathVariable("hotelName") String hotelName) throws HotelNotFoundException {
		return ResponseEntity.ok(service.updateHotelNameById(hotelId, hotelName));
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updatehotelContactById
	 - Input Parameters : Hotel hotel, Integer id
	 - Return type      : String
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to update a hotel phone number based on its ID.
	 - EndPoint URL		: http://localhost:8183/updateContact/{hotelId}/{phoneNo}
	  ****************************************************************************************************************************/ 
	
	@PutMapping("/updateContact/{hotelId}/{phoneNo}")
	public ResponseEntity<String> updatehotelContactById
	(@PathVariable("hotelId") Integer hotelId, @PathVariable("phoneNo") String phoneNo) throws HotelNotFoundException {
		return ResponseEntity.ok(service.updateHotelPhoneNoById(hotelId, phoneNo));
	}
	
	/****************************************************************************************************************************
	 - Method Name      : getAllHotelByNameInOrder
	 - Return type      : List<Hotel>
	 - Author           : Dinesh Sharma
	 - Creation Date    : 10-6-2020
	 - Description      : Method to fetch all hotel details sorted by name
	 - EndPoint URL		: http://localhost:8183/getHotelByNameInOrder
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getHotelByNameInOrder")
	public List<Hotel> getAllHotelByNameInOrder() throws HotelNameNotFoundException {

		return service.getHotelByNameInOrder();
	}
}
