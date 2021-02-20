package com.truongta.DAOs;

import javax.persistence.EntityManager;

import com.truongta.entities.Favorite;
import com.truongta.entities.Seen;
import com.truongta.entities.Share;
import com.truongta.utils.JpaUtil;

public class ShareDao {
	private EntityManager m = JpaUtil.getManager();
	
	public Share  findById(String id) {
		Share f = m.find(Share.class, id);
		return f;
	}
	
	public Share create(Share f) {
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
	
	public Share updata(Share f) {
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
	
	public Share remove(String id) {
		try {
			Share f = this.findById(id);
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
