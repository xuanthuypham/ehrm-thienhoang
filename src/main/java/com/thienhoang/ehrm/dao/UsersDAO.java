package com.thienhoang.ehrm.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import com.thienhoang.ehrm.model.Users;



import org.hibernate.cfg.Configuration;

public class UsersDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<Users> getList()
	{
		List<Users> list= null;
	        try
	        {
	        	list = new ArrayList<Users>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from Users";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
		        
	        	
//	        	list = session.createQuery("from MasterDatas where masterDataTypes= "+TYPE_ID).list();
//	        	transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	public Users getUserByUsename(String uname)
	{
		Users us = new Users();
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
        String hql ="from Users where userName= :name";
        Query que = session.createQuery(hql);
        que.setParameter("name", uname);
        us = (Users) que.uniqueResult();
        transaction.commit();
		return us;
	}
}


