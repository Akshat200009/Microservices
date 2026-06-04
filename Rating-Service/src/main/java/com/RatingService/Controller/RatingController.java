package com.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingService.Entities.Ratings;
import com.RatingService.Services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingservice;

	@PostMapping("/create")
	public Ratings createRating(@RequestBody Ratings rating) {
		Ratings newRating = ratingservice.create(rating);
		return newRating;
	}

	@GetMapping("/all")
	public List<Ratings> getAllRatings() {
		List<Ratings> allratings = ratingservice.getAll();
		return allratings;
	}

	@GetMapping("/users/{userid}")
	public List<Ratings> getRatingbyUserid(@PathVariable Integer userid) {
		List<Ratings> getbyuserid = ratingservice.getByUserId(userid);
		return getbyuserid;
	}

	@GetMapping("/hotels/{hotelid}")
	public List<Ratings> getRatingnyHotelid(@PathVariable Integer hotelid) {
		List<Ratings> getbyhotelid = ratingservice.getbyHotelId(hotelid);
		return getbyhotelid;
	}
}
