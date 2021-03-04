package com.truongta.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.truongta.entities.Favorite;
import com.truongta.entities.Report;
import com.truongta.entities.User;
import com.truongta.entities.UserFav;
import com.truongta.entities.UserShare;
import com.truongta.utils.JpaUtil;

public class ReportDao {
	
	private EntityManager manager = JpaUtil.getManager();
	
	@Override
	protected void finalize() throws Throwable {
		manager.close();
		super.finalize();
	}
	
	public List<Report> getReport() {
		String jpql = "SELECT new Report(o.video.title,o.video.id,count(o),max(o.likeDaTe),min(o.likeDaTe)) "
				+ "FROM Favorite o group by o.video.title,o.video.id";
		TypedQuery<Report> query = manager.createQuery(jpql,Report.class);
		List<Report> list = query.getResultList();
		return list;
	}
	public List<UserFav> getFavoriteByUser(String idv) {
		
		String jpql = "SELECT DISTINCT new UserFav(f.user.id,f.user.fullName,f.user.email,f.likeDaTe)"
				+ "FROM Favorite f where f.video.id =:idv group by f.video.title,f.user.id,f.user.fullName,f.user.email,f.likeDaTe";
		
		TypedQuery<UserFav> q = manager.createQuery(jpql,UserFav.class);
		q.setParameter("idv", idv);
		List<UserFav> list = q.getResultList();
		return list;
	}
	
	public List<UserShare> getUserShare(String idv) {
		String jpql = "SELECT new UserShare(o.user.id,o.user.email,o.email,o.DateShare) "
				+ "FROM Share o WHERE o.video.id=:idv group by o.user.id,o.user.email,o.email,o.DateShare ";
		TypedQuery<UserShare> q = manager.createQuery(jpql, UserShare.class);
		q.setParameter("idv", idv);
		List<UserShare> list = q.getResultList();
		return list;
	}
	
}
