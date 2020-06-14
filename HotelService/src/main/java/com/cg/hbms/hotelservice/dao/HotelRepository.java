/****************************************************************************************************************************
 - File Name      	: HotelRepository
 - Author           : Dinesh Sharma
 - Creation Date    : 10-06-2020
 - Description      : This is an interface for HotelService which extends JpaRepository to perform all the basic crud operations
  ****************************************************************************************************************************/ 

package com.cg.hbms.hotelservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

	/****************************************************************************************************************************
	 * - Method Name : findByName 
	 * - Input Parameters :  String name
	 * - Return type : List<HotelEntity> 
	 * - Author : Dinesh Sharma 
	 * - Creation Date 10-6-2020 
	 * - Description : Method to fetch a hotel with details by a particular name
	 * 
	 ****************************************************************************************************************************/
	
	@Query("select h from Hotel h where h.hotelName = :name")	
	List<HotelEntity> findByName(@Param("name") String name);
	
	/****************************************************************************************************************************
	 * - Method Name : findByNameAsc 
	 * - Input Parameters :  Not Required
	 * - Return type : List<HotelEntity> 
	 * - Author : Dinesh Sharma 
	 * - Creation Date 10-6-2020 
	 * - Description :Method to fetch all hotels with details sorted by hotelName
	 * 
	 ****************************************************************************************************************************/
	
	@Query("select h from Hotel h ORDER BY h.hotelName")	
	List<HotelEntity> findByNameSortedByName();
}
