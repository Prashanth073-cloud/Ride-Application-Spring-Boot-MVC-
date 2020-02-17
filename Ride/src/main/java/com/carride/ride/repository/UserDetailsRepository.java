package com.carride.ride.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carride.ride.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
	@Query(value = "SELECT * FROM homemates.tbl_user_details", nativeQuery = true)
	ArrayList<UserDetails> getUserDetails();

	@Query(value = "Select * from homemates.tbl_user_details where group_name=?1 and email_address=?2", nativeQuery = true)
	ArrayList<UserDetails> getFreindsList(String groupName, String emailAddress);
}
