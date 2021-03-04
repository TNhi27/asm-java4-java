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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Favorites",uniqueConstraints = {@UniqueConstraint(columnNames = {"VideoId","UserId"})})
public class Favorite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	Long id;
	@Temporal(TemporalType.DATE)
	Date likeDaTe=new Date();
	
	@ManyToOne @JoinColumn(name = "VideoId")
	Video video;
	@ManyToOne @JoinColumn(name = "UserId")
	User user;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getLikeDaTe() {
		return likeDaTe;
	}
	public void setLikeDaTe(Date likeDaTe) {
		this.likeDaTe = likeDaTe;
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
