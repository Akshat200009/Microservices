package com.RatingService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingService.Entities.Ratings;
import com.RatingService.Repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingrepo;

	public Ratings create(Ratings rating) {
		return ratingrepo.save(rating);
	}

	public List<Ratings> getAll() {
		return ratingrepo.findAll();
	}

	public List<Ratings> getByUserId(Integer userid) {
		return ratingrepo.findByUserid(userid);
	}
	
	public List<Ratings> getbyHotelId(Integer hotelid)
	{
		return ratingrepo.findByHotelid(hotelid);
	}

}
