package com.truongta.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.truongta.entities.User;
import com.truongta.utils.JpaUtil;

public class UserDao {
	private EntityManager manager = JpaUtil.getManager();
	
	@Override
	protected void finalize() throws Throwable {
		manager.close();
		super.finalize();
	}
	
	public User findById(String id) {
		User u = manager.find(User.class, id);
		return u;
	}
	public List<User> findVideo(String idv) {
		String sql = "SELECT o.user FROM Favorite o where o.video.id=:idv";
		TypedQuery<User> query = manager.createQuery(sql, User.class);
		query.setParameter("idv", idv);
		List<User> list = query.getResultList();
		return list;
	}
	
	public List<User> findAll() {
		String sql = "SELECT o FROM User o";
		TypedQuery<User> query = manager.createQuery(sql, User.class);
		List<User> list = query.getResultList();
		return list;
	}
	
	public User create(User u) {
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
	
	public User update(User u) {
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
	public User remove(String id) {
		try {
			User u = this.findById(id);
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
