package com.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.Entities.User;
import com.UserService.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userserv;

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {

		User user1 = userserv.saveUser(user);

		return user1;
	}

	@GetMapping("/{id}")
	public User getSingleuser(@PathVariable Long id) {
		User user = userserv.getUserbyId(id);
		return user;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() 
	{
		List<User> alluser = userserv.getallUsers();
        return alluser;
	}
}
