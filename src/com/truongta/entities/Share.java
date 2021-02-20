package com.truongta.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Share")
public class Share {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	@Column(name = "Email")
	String email;
	@Temporal(TemporalType.DATE)
	@Column(name ="DateShare")
	Date DateShare = new Date();
	
	@ManyToOne @JoinColumn(name = "ID_Video")
	Video video;
	@ManyToOne @JoinColumn(name = "ID_User")
	User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateShare() {
		return DateShare;
	}
	public void setDateShare(Date dateShare) {
		DateShare = dateShare;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		
}
