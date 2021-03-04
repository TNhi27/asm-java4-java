package com.truongta.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserFav {
	@Id
	Serializable userID;
	String fullName;
	String email;
	Date day;
	
	public Serializable getUserID() {
		return userID;
	}
	public void setUserID(Serializable userID) {
		this.userID = userID;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public UserFav(Serializable userID, String fullName, String email, Date day) {
		
		this.userID = userID;
		
		this.fullName = fullName;
		this.email = email;
		this.day = day;
	}
	
}
