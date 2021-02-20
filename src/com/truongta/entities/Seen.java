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
@Table(name = "Seen",uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_Video","ID_User"})})
public class Seen {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	@Temporal(TemporalType.DATE)
	Date dateSeen=new Date();
	
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
	public Date getDataSeen() {
		return dateSeen;
	}
	public void setDataSeen(Date dataSeen) {
		dateSeen = dataSeen;
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
