package com.HotelService.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping
	public List<String> getAllStaffs()
	{
		List<String> list = Arrays.asList("JOHN","JACOBS","VINCENT","CHASE");
		return list;
	}
}
      