package com.truongta.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserShare {
	@Id
	String fromUser;
	String fromEmail;
	String toEmail;
	Date daySend;
	public UserShare(String fromUser, String fromEmail, String toEmail, Date daySend) {
		
		this.fromUser = fromUser;
		this.fromEmail = fromEmail;
		this.toEmail = toEmail;
		this.daySend = daySend;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public Date getDaySend() {
		return daySend;
	}
	public void setDaySend(Date daySend) {
		this.daySend = daySend;
	}
	
	
}
