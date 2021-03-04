package com.truongta.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.truongta.entities.User;
import com.truongta.entities.Video;
import com.truongta.utils.JpaUtil;

public class VideoDao {
	
	private EntityManager manager = JpaUtil.getManager();

	@Override
	protected void finalize() throws Throwable {
		manager.close();
		super.finalize();
	}
	
	public Video findById(String id) {
		Video v = manager.find(Video.class, id);
		return v;
	}
	public List<Video> findTop6() {
		TypedQuery<Video> q = manager.createNamedQuery("Report.random6", Video.class);
		List<Video> list = q.getResultList();
		return list;
	}
	public List<Video> findByKeyword(String key) {
		String jpql = "SELECT DISTINCT o.video FROM Favorite o where o.video.title LIKE :key";
		TypedQuery<Video> query = manager.createQuery(jpql, Video.class);
		query.setParameter("key", "%"+key+"%");
		List<Video> list = query.getResultList();
		return list;
	}
	public List<Video> findWithEmpty(boolean isEmpty) {
		String jpql="SELECT o FROM Video o WHERE o.favorite IS EMPTY" ;
		if (isEmpty) {
			jpql = "SELECT o FROM Video o WHERE o.favorite IS NOT EMPTY";
		}
		TypedQuery<Video> query = manager.createQuery(jpql, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
	
	
	
	public List<Video> findAll() {
		String sql = "SELECT o FROM Video o";
		TypedQuery<Video> query = manager.createQuery(sql, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
	
	public Video create(Video u) {
		try {
			manager.getTransaction().begin();
			manager.persist(u);
			manager.getTransaction().commit();
			return u;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public Video update(Video u) {
		try {
			manager.getTransaction().begin();
			manager.merge(u);
			manager.getTransaction().commit();
			return u;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}
	public Video remove(String id) {
		try {
			Video u = this.findById(id);
			manager.getTransaction().begin();
			manager.remove(u);
			manager.getTransaction().commit();
			return u;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}
}
