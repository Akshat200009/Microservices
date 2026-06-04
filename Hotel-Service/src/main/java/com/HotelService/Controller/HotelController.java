package com.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.Entities.Hotel;
import com.HotelService.Services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelserv;
	
	@PostMapping("/create")
	public Hotel createhotel(@RequestBody Hotel hotel)
	{
		Hotel hotel1 = hotelserv.createHotel(hotel);
		
		return hotel1;
	}
	
	@GetMapping("/{id}")
	public Hotel getHotel(@PathVariable Integer id) {
	    return hotelserv.getHotel(id);
	}
	
	@GetMapping("/all")
	public List<Hotel> allHotels()
	{
		List<Hotel> getallHotels = hotelserv.getAllhotels();
		return getallHotels;
	}
}
