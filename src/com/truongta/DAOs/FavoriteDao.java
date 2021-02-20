package com.truongta.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.truongta.entities.Favorite;
import com.truongta.entities.User;
import com.truongta.utils.JpaUtil;

public class FavoriteDao {
	private EntityManager m = JpaUtil.getManager();
	
	public List<Favorite> findAll() {
		String sql = "SELECT o FROM Favorite o";
		TypedQuery<Favorite> query = m.createQuery(sql, Favorite.class);
		List<Favorite> list = query.getResultList();
		return list;
	}
	
	public List<Favorite> findByUser(String id) {
		String sql = "SELECT DISTINCT o FROM Favorite o WHERE o.user.id=:id";
		TypedQuery<Favorite> query = m.createQuery(sql, Favorite.class);
		query.setParameter("id", id);
		List<Favorite> list = query.getResultList();
		return list;
	}
	
	public Favorite  findById(long id) {
		Favorite f = m.find(Favorite.class, id);
		return f;
	}
	
	public Favorite create(Favorite f) {
		try {
			m.getTransaction().begin();
			m.persist(f);
			m.getTransaction().commit();
			return f;
		} catch (Exception e) {
			m.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public Favorite updata(Favorite f) {
		try {
			m.getTransaction().begin();
			m.merge(f);
			m.getTransaction().commit();
			return f;
		} catch (Exception e) {
			m.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Favorite remove(Long long1) {
		try {
			Favorite f = this.findById(long1);
			m.getTransaction().begin();
			m.remove(f);
			m.getTransaction().commit();
			return f;
		} catch (Exception e) {
			m.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return null;
	}
}
