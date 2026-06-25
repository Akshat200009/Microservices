 package com.RatingService.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.RatingService.Entities.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, Integer> {

	List<Ratings> findByUserid(Integer userid);
	List<Ratings> findByHotelid(Integer hotelid);
}
