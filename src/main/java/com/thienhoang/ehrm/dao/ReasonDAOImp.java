package com.thienhoang.ehrm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.thienhoang.ehrm.dao.interfaces.ModelDAO;
import com.thienhoang.ehrm.dao.interfaces.ReasonsDAO;
import com.thienhoang.ehrm.model.Reasons;

@Repository("reasonDao")
public class ReasonDAOImp extends ModelDAO implements ReasonsDAO{
	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Reasons> getList() {
		// TODO Auto-generated method stub
		session = getSession();
		List<Reasons> list = null;
		try {
			Query que = session.createQuery("from Reasons");
			list = que.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
