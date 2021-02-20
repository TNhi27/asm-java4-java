package com.truongta.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.truongta.entities.Favorite;
import com.truongta.entities.Seen;
import com.truongta.entities.User;
import com.truongta.entities.Video;
import com.truongta.utils.JpaUtil;

public class SeenDao {
	private EntityManager m = JpaUtil.getManager();
	
	public List<Video> getSeenVideo(String UserId) {
		String jpql = "SELECT DISTINCT o.video FROM Seen o WHERE o.user.id=:UserId";
		TypedQuery<Video> q = m.createQuery(jpql, Video.class);
		q.setParameter("UserId", UserId);
		List<Video> list = q.getResultList();
		return list;
	}
	
	public Seen  findById(String id) {
		Seen f = m.find(Seen.class, id);
		return f;
	}
	
	public Seen create(Seen f) {
		try {
			m.getTransaction().begin();
			m.persist(f);
			System.out.println("Tao seen ");
			m.getTransaction().commit();
			return f;
		} catch (Exception e) {
			m.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public Seen updata(Seen f) {
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
	
	public Seen remove(String id) {
		try {
			Seen f = this.findById(id);
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
