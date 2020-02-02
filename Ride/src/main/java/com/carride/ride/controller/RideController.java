package com.carride.ride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RideController {

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
}
