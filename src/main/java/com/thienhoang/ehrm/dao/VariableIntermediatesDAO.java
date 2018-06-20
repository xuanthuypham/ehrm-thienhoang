package com.thienhoang.ehrm.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.thienhoang.ehrm.model.MasterDatas;
import com.thienhoang.ehrm.model.Periods;
import com.thienhoang.ehrm.model.VariableIntermediates;

public class VariableIntermediatesDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<VariableIntermediates> getList()
	{
		List<VariableIntermediates> list= null;
	        try
	        {
	        	list = new ArrayList<VariableIntermediates>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from Periods ";
		        Query que = session.createQuery(hql);
//		        que.setFirstResult(start);
//		        que.setMaxResults(next);
		        list = que.list();
		        transaction.commit();
		        //session.close();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	
}
