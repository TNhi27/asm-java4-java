package com.truongta.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "sp",
			procedureName = "spFavoriteByYear",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN,type = Long.class,name = "year")
			}
		)
})

//@NamedNativeQueries({
//    @NamedNativeQuery(
//    name = "Report.favoriteByYear",
//    query = "exec spFavoriteByYear :year",
//    resultClass = Report.class
//    )
//})
@Entity
public class Report {
	@Id
	Serializable gr;
	Long likes;
	Date newest;
	Date oldest;

	public Report(Serializable gr, Long likes, Date newest, Date oldest) {

		this.gr = gr;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public Report() {
	}

	public Serializable getGr() {
		return gr;
	}

	public void setGr(Serializable gr) {
		this.gr = gr;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
