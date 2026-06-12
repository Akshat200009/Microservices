package com.UserService.Services;


import java.util.Arrays;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserService.Entities.Hotel;
import com.UserService.Entities.Ratings;
import com.UserService.Entities.User;
import com.UserService.External.Service.HotelService;
import com.UserService.External.Service.NewUserService;
import com.UserService.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemp;
	
	@Autowired
	private HotelService hotelserv; 
	
	@Autowired
	private NewUserService userserv;
	
//	private Logger logger = LoggerFactory.getLogger(UserService.class);

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getallUsers() {
		return userRepo.findAll();
	}

	public User getUserbyId(Long userId) {
	   User user = userRepo.findById(userId).orElse(null);
	   Ratings[] forobject= userserv.getRating(user.getId());
	
	   
//		logger.info("{}",forobject);
	  List<Ratings> ratings = Arrays.stream(forobject).toList();
	  
	  List<Ratings> ratinglist = ratings.stream()
		        .map(rating -> {

		            Hotel hotel = hotelserv.getHotel(
		                    rating.getHotelid());

		            rating.setHotel(hotel);

		            return rating;
		        })
		        .toList();
		  
	  
	  user.setRatings(ratinglist);
		return user;
	}
}
