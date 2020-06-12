package com.cg.hotelbookingmanagementsystem.HotelService.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

	@Query("select h from Hotel h where h.hotelName = :name")	
	List<HotelEntity> findByName(@Param("name") String name);
	
	
	@Query("select h from Hotel h ORDER BY h.hotelName")	
	List<HotelEntity> findByNameAsc();
}
