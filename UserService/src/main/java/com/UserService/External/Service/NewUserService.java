package com.UserService.External.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UserService.Entities.Ratings;

@FeignClient(name="RATING-SERVICE")
public interface NewUserService {

	@GetMapping("/ratings/users/{userid}")
	Ratings[] getRating(@PathVariable Long id);
}
