package com.UserService.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserService.Entities.Hotel;
import com.UserService.Entities.Ratings;
import com.UserService.Entities.User;
import com.UserService.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemp;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getallUsers() {
		return userRepo.findAll();
	}

	public User getUserbyId(Long userId) {
	   User user = userRepo.findById(userId).orElse(null);
	   Ratings[] forobject= restTemp.getForObject("http://RATING-SERVICE/ratings/users/"+user.getId()
				, Ratings[].class);
		logger.info("{}",forobject);
	  List<Ratings> ratings = Arrays.stream(forobject).toList();
	  
	  List<Ratings> ratinglist = ratings.stream()
			    .map(rating -> {

			        Hotel hotel = restTemp.getForObject(
			                "http://HOTEL-SERVICE/hotels/" + rating.getHotelid(),
			                Hotel.class);

			        rating.setHotel(hotel);

			        return rating;
			    }).toList();		  
		  
	  
	  user.setRatings(ratinglist);
		return user;
	}
}
