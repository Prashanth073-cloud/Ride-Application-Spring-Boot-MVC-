package com.carride.ride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "tbl_userDetails")
public class UserDetails {
	
	public UserDetails() {
		
	}
	
	public UserDetails(Integer userId, String userName, GroupNames groupNames, String groupName, String emailAddress,
			String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.groupNames = groupNames;
		this.groupName = groupName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public UserDetails(GroupNames groupNames) {
		this.groupNames=groupNames;
	}

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	Integer userId;

	@Column(name = "userName")
	String userName;

	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false)
	private GroupNames groupNames;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "groupName")
	String groupName;

	@Column(name = "emailAddress")
	String emailAddress;

	@Column(name = "password")
	String password;

}
