package com.carride.ride.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_groupNames")
public class GroupNames {

	public GroupNames(String groupNames) {
		this.groupNames = groupNames;
	}
	
	public GroupNames() {
		
	}

	@Id
	@GeneratedValue
	@Column(name = "group_id")
	int groupId;

	@OneToMany(mappedBy = "groupNames", cascade = CascadeType.ALL)
	public List<UserDetails> userDetailsList;

	public List<UserDetails> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetails> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

	@Column(name = "groupNames")
	String groupNames;

	public int getId() {
		return groupId;
	}

	public void setId(int id) {
		this.groupId = id;
	}

	public String getGroupNames() {
		return groupNames;
	}

	public void setGroupNames(String groupNames) {
		this.groupNames = groupNames;
	}
}
