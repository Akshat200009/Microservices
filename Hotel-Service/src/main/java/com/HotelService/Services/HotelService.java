package com.HotelService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Entities.Hotel;
import com.HotelService.Repositories.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelrepo;
	
	public Hotel createHotel(Hotel hotel)
	{
		return hotelrepo.save(hotel);
	}
	
	public Hotel getHotel(Integer id) {
	    return hotelrepo.findById(id).orElse(null);
	}
	
	public List<Hotel> getAllhotels()
	{
	    return hotelrepo.findAll();
	  
	}
}
