package com.UserService.External.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UserService.Entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/hotels/{id}")
	 Hotel getHotel(@PathVariable("id") int id);
}
