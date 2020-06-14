/****************************************************************************************************************************
 - File Name      	: HotelServiceImpl
 - Author           : Dinesh Sharma
 - Creation Date    : 10-06-2020
 - Description      : This is a service class which contains the business logic of Hotel Service
  ****************************************************************************************************************************/

package com.cg.hbms.hotelservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbms.hotelservice.dao.HotelEntity;
import com.cg.hbms.hotelservice.dao.HotelRepository;
import com.cg.hbms.hotelservice.dto.Hotel;
import com.cg.hbms.hotelservice.exception.HotelNameNotFoundException;
import com.cg.hbms.hotelservice.exception.HotelNotFoundException;

@Service
public class HotelServiceImpl implements HotelServiceInterface {

	@Autowired
	private HotelRepository repository;

	Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	/****************************************************************************************************************************
	 * - Method Name : isRepositoryNotNull - Return type : boolean - Author : Dinesh
	 * Sharma - Creation Date 10-6-2020 - Description : Method to check if we are
	 * injecting required bean or not.
	 ****************************************************************************************************************************/

	public boolean isRepositoryNotNull() {
		boolean flag = false;

		if (repository != null) {
			flag = true;

		}
		return flag;
	}

	/****************************************************************************************************************************
	 * - Method Name : getHotelList - Input Parameters : No input parameters -
	 * Return type : List<Hotel> - Author : Dinesh Sharma - Creation Date 10-6-2020
	 * - Description : Method to fetch all hotels with details
	 ****************************************************************************************************************************/

	public List<Hotel> getHotelList() throws HotelNotFoundException {
		if (!isRepositoryNotNull()) {

			logger.error("Problem with connectivity with service to DAO layer");
			throw new HotelNotFoundException("Sorry for the inconvinience, currently database is down!");

		}
		List<HotelEntity> entity = repository.findAll();
		List<Hotel> hotelList = new ArrayList<>();

		for (HotelEntity hotelEntity : entity) {

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

	/****************************************************************************************************************************
	 * - Method Name : getHotelByName - Input Parameters : String hotelname - Return
	 * type : List<Hotel> - Author : Dinesh Sharma - Creation Date : 10-6-2020 -
	 * Description : Method to fetch List of hotels with particular name
	 * 
	 ****************************************************************************************************************************/

	public List<Hotel> getHotelByName(String hotelname) throws HotelNameNotFoundException {
		if (!isRepositoryNotNull()) {

			logger.error("Problem with connectivity with service to DAO layer");
			throw new HotelNameNotFoundException("Sorry for the inconvinience, currently database is down!");

		}
		List<HotelEntity> entityList = repository.findByName(hotelname);
		if (!entityList.isEmpty()) {
			List<Hotel> hotelList = new ArrayList<>();
			for (HotelEntity hotelEntity : entityList) {
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
		} else {
			throw new HotelNameNotFoundException("No Hotel with " + hotelname + " name is found");
		}
	}

	/****************************************************************************************************************************
	 * - Method Name : getHotelById - Input Parameters : Integer hotelId - Return
	 * type : Hotel - Author : Dinesh Sharma - Creation Date : 10-6-2020
	 * -Description : Method to fetch all hotels with details with particular name
	 * 
	 ****************************************************************************************************************************/

	public Hotel getHotelById(Integer hotelId) throws HotelNotFoundException {
		if (!isRepositoryNotNull()) {

			logger.error("Problem with connectivity with service to DAO layer");
			throw new HotelNotFoundException("Sorry for the inconvinience, currently database is down!");

		}
		Optional<HotelEntity> optional = repository.findById(hotelId);
		if (optional.isPresent()) {
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
		} else {
			throw new HotelNotFoundException("no hotel found with " + hotelId + " Id.");
		}

	}

	/****************************************************************************************************************************
	 * - Method Name : addHotel 
	 * - Input Parameters : Hotel hotel 
	 * - Return type : String 
	 * - Author : Dinesh Sharma 
	 * - Creation Date : 10-6-2020 
	 * - Description : Method to add hotel in database
	 * 
	 ****************************************************************************************************************************/

	public String addHotel(Hotel hotel) throws HotelNotFoundException {

		if (!isRepositoryNotNull()) {

			logger.error("Problem with connectivity with service to DAO layer");
			throw new HotelNotFoundException("Sorry for the inconvinience, currently database is down!");

		}
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

	/******************************************
	 * - Method Name : updateHotelContactById - Input Parameters : hotelId, phoneNo
	 * - Return type : String 
	 * - Author : Dinesh Sharma 
	 * - Creation Date : 13-06-2020 
	 * -Description : To update existing hotel contact details in database.
	 *******************************************/
	@Override
	public String updateHotelPhoneNoById(Integer hotelId, String phoneNo) throws HotelNotFoundException {
		if (!isRepositoryNotNull()) {
			logger.error("Sorry for the inconvenience, currently DataBase is down..!");
		}
		Optional<HotelEntity> optional = repository.findById(hotelId);
		if (optional.isPresent()) {
			HotelEntity entity = optional.get();

			entity.setPhoneNo(phoneNo);
			repository.saveAndFlush(entity);

			return "Hotel Contact number updated successfully!";
		} else
			throw new HotelNotFoundException("Hotel not found for the given Id");
	}

	/******************************************
	 * - Method Name : updateHotelCityById - Input Parameters : hotelId, City -
	 * Return type : String - Author : Dinesh Sharma - Creation Date : 13-06-2020 -
	 * Description : To update existing Hotel contact details in database.
	 ******************************************/
	@Override
	public String updateHotelCityById(Integer hotelId, String city) throws HotelNotFoundException {
		if (!isRepositoryNotNull()) {
			logger.error("Problem with dependency injection..!");
			throw new HotelNotFoundException("Sorry for the inconvenience, currently DataBase is down..!");
		}
		Optional<HotelEntity> optional = repository.findById(hotelId);
		if (optional.isPresent()) {
			HotelEntity entity = optional.get();

			entity.setCity(city);
			repository.save(entity);

			return "Hotel City updated successfully!";
		} else
			throw new HotelNotFoundException("Hotel Not found not found for the given Id");
	}

	/******************************************
	 * - Method Name : updateHotelCityById - Input Parameters : hotelId, name -
	 * Return type : String - Author : Dinesh Sharma - Creation Date : 13-06-2020 -
	 * Description : To update existing Hotel Name in database.
	 ******************************************/
	@Override
	public String updateHotelNameById(Integer hotelId, String name) throws HotelNotFoundException {
		if (!isRepositoryNotNull()) {
			logger.error("Sorry for the inconvenience, currently DataBase is down..!");
		}
		Optional<HotelEntity> optional = repository.findById(hotelId);
		if (optional.isPresent()) {
			HotelEntity entity = optional.get();

			entity.setHotelName(name);
			repository.save(entity);

			return "Hotel Contact number updated successfully!";
		} else
			throw new HotelNotFoundException("Hotel not found for the given Id");
	}

	/****************************************************************************************************************************
	 * - Method Name : deleteById 
	 * - Input Parameters : Integer hotelid 
	 * - Return type  : String 
	 * - Author : Dinesh Sharma 
	 * - Creation Date : 10-6-2020 
	 * - Description : Method to delete hotel with a particular ID
	 ****************************************************************************************************************************/

	public String deleteById(Integer hotelid) throws HotelNotFoundException {
		if (!isRepositoryNotNull()) {

			logger.error("Problem with connectivity with service to DAO layer");
			throw new HotelNotFoundException("Sorry for the inconvinience, currently database is down!");

		}

		Optional<HotelEntity> optional = repository.findById(hotelid);

		if (optional.isPresent()) {
			HotelEntity entity = optional.get();
			repository.delete(entity);
			return "Hotel Deleted successfully";
		} else {
			return "Hotel with " + hotelid + " can not be found";
		}
	}

	/****************************************************************************************************************************
	 * - Method Name : getHotelByNameInOrder
	 * - Input Parameters : No input parameters are required 
	 * - Return type : List<Hotel> 
	 * - Author : Dinesh Sharma
	 * - Creation Date : 10-6-2020 
	 * - Description : Method to fetch all hotels with details sorted by names
	 ****************************************************************************************************************************/

	public List<Hotel> getHotelByNameInOrder() throws HotelNameNotFoundException {
		if (!isRepositoryNotNull()) {

			logger.error("Problem with connectivity with service to DAO layer");
			throw new HotelNameNotFoundException("Sorry for the inconvinience, currently database is down!");

		}

		List<HotelEntity> entityList = repository.findByNameSortedByName();
		if (!entityList.isEmpty()) {

			List<Hotel> hotelList = new ArrayList<>();
			for (HotelEntity hotelEntity : entityList) {
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
		} else
			return Collections.emptyList();

	}
}
