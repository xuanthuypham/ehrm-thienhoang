package com.thienhoang.ehrm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.thienhoang.ehrm.dao.interfaces.ModelDAO;
import com.thienhoang.ehrm.dao.interfaces.UnitDAO;
import com.thienhoang.ehrm.model.Units;

@Repository("unitDao")
public class UnitDAOImp extends ModelDAO implements UnitDAO {

	Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Units> getList() {
		// TODO Auto-generated method stub
		session = getSession();
		List<Units> list = null;
		try {
			Query que = session.createQuery("From Units");
			list = que.list();	
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Units findById(Integer ID) {
		// TODO Auto-generated method stub
		session = getSession();
		Units unit = null;
		try {
			Query que = session.createQuery("From Units where unitId = "+ID);
			unit = (Units) que.uniqueResult();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return unit;	}

}
