package com.carride.ride.controller;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carride.ride.classfiles.AES;
import com.carride.ride.classfiles.Constants;
import com.carride.ride.model.GroupNames;
import com.carride.ride.model.UserDetails;
import com.carride.ride.repository.GroupNameRepository;
import com.carride.ride.repository.UserDetailsRepository;

import antlr.collections.List;

@Controller
public class RideController {

	String groupName = "";

	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Autowired
	GroupNameRepository groupNamesRepository;

	@GetMapping("/")
	public String getIndex() {
		return "login";
	}

	@PostMapping("/houseWork")
	public String getUserDetails(@ModelAttribute("userDetails") UserDetails userDetails,
			Model customeUserDetailsModel) {

		UserDetails userDetailsModel;
		Set<GroupNames> groNamesSet = groupNamesRepository.getUserDetails(); // getting groupName table data

		if (groNamesSet.size() > 0) { // if set has some results,it means table is already created and has some data
			GroupNames groupNames = groNamesSet // checking if a set(table) has same group name as user entered
					.stream().filter(result -> userDetails.getGroupName().equals(result.getGroupNames())).findAny()
					.orElse(null);
			if (groupNames != null) { // if group name is not null then table has data with user entered group name.
										// instead of creating new record for already existing table name,use the
										// existing record
				userDetailsModel = new UserDetails(groupNames); // passing the existing object to userdetails
																// model(table) so that it wont create new
																// data in foreign key

			} else { // creating new row in both tables
				GroupNames groupNamesModel = new GroupNames(userDetails.getGroupName());
				groupNamesRepository.save(groupNamesModel);
				userDetailsModel = new UserDetails(groupNamesModel);
			}
		} else {
			GroupNames groupNamesModel = new GroupNames(userDetails.getGroupName());
			groupNamesRepository.save(groupNamesModel);
			userDetailsModel = new UserDetails(groupNamesModel);
		}

		// encrypting password and email to store in db
		String password = AES.encrypt(userDetails.getPassword(), Constants.SECRET_KEY);
		String email = AES.encrypt(userDetails.getEmailAddress(), Constants.SECRET_KEY);

		groupName = userDetails.getGroupName();
		// setting data to userdetails table
		userDetailsModel.setGroupName(userDetails.getGroupName());
		userDetailsModel.setUserName(userDetails.getUserName());
		userDetailsModel.setGroupName(userDetails.getGroupName());
		userDetailsModel.setPassword(password);
		userDetailsModel.setEmailAddress(email);

		userDetailsRepository.save(userDetailsModel);
		System.out.println("--------------------------------------" + userDetails.getUserName());

		return "houseWork";
	}

	@RequestMapping("/login")
	public String getIndexPage() {

		return "login";
	}

	@RequestMapping("/updateWork")
	public String getIndexPage(@RequestParam("emailAddress") String email, @RequestParam("password") String password,
			HttpSession session) {
		ArrayList<UserDetails> userDetailsList = userDetailsRepository.getUserDetails();

		UserDetails userDetails = userDetailsList.stream()
				.filter(user -> email.equals(AES.decrypt(user.getEmailAddress(), Constants.SECRET_KEY))
						&& password.equals(AES.decrypt(user.getPassword(), Constants.SECRET_KEY)))
				.findAny().orElse(null);

		if (userDetails != null) {

			session.setAttribute("email", userDetails.getEmailAddress()); // storing
																			// email
			System.out.println("---------------" + session.getAttribute("email")); // in
			// session
			session.setAttribute("groupName", userDetails.getGroupName()); // storing
																			// groupname
																			// in
																			// session
		}
		return "houseWork";
	}
	
	@RequestMapping("/friendsList")
	public String getFriendsList() {
		System.out.println("-------------------freindsList method---------------------");
		return "friendsList";
	}

	@RequestMapping("/register")
	public String getRegisterPage() {
		return "register";
	}
}
