package com.UserService.External.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.UserService.Entities.User;

@FeignClient(name="USERSERVICE")
public interface AllUsersService {
        
	@GetMapping("/users/all")
	List<User> getAllUsers();
}
