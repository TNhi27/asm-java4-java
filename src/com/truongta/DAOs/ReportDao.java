package com.truongta.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.truongta.entities.Report;
import com.truongta.utils.JpaUtil;

public class ReportDao {
	
	private EntityManager manager = JpaUtil.getManager();
	
	@Override
	protected void finalize() throws Throwable {
		manager.close();
		super.finalize();
	}
	
	public List<Report> getReport() {
		String jpql = "SELECT new Report(o.video.title,count(o),max(o.likeDaTe),min(o.likeDaTe)) FROM Favorite o group by o.video.title";
		TypedQuery<Report> query = manager.createQuery(jpql,Report.class);
		List<Report> list = query.getResultList();
		return list;
	}
}
