package com.UserService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserService.Entities.User;
import com.UserService.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getallUsers() {
		return userRepo.findAll();
	}

	public User getUserbyId(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
}
