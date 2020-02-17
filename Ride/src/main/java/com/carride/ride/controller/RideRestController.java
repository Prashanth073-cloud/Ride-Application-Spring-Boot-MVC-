package com.carride.ride.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carride.ride.model.UserDetails;
import com.carride.ride.repository.UserDetailsRepository;

@RestController
public class RideRestController {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@RequestMapping("/friendsData")
	public ArrayList<UserDetails> getFriendsList(HttpSession session) {
		System.out.println("Rest controller------------------");

		String email = session.getAttribute("email").toString();
		String groupName = session.getAttribute("groupName").toString();

		ArrayList<UserDetails> userDetailsList = userDetailsRepository.getFreindsList(groupName, email);

		return userDetailsList;
	}
}
