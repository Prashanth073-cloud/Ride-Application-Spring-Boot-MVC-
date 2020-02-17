package com.carride.ride.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carride.ride.model.GroupNames;

@Repository
public interface GroupNameRepository extends JpaRepository<GroupNames, Integer> {
	@Query(value = "SELECT * FROM homemates.tbl_group_names", nativeQuery = true)
	Set<GroupNames> getUserDetails();
}
