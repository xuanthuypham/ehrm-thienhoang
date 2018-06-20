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

public class PeriodDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<Periods> getList(String year)
	{
		List<Periods> list= null;
	        try
	        {
	        	list = new ArrayList<Periods>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from Periods where YEAR(END_DATE)="+year;
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
	public int search(String year, String month)
	{
		Periods per = null;
		int id = 0;
	       try
	       {
	        	Session session = getSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from Periods where YEAR(END_DATE) = '"+year+"' and PERIOD_NAME= '"+month+"'";
		        Query que = session.createQuery(hql);
		        per = (Periods) que.uniqueResult();
		        id = per.getPeriodId();
		        transaction.commit();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return id;	
	}
	public static void main(String[] args) {
//		List<Periods> lst = new PeriodDAO().getList("2013");
//		for(Periods fn :lst)
//		{
//			System.out.println(fn);
//		}
		
		int id = new PeriodDAO().search("2013", "August");
		System.out.println(id);
	}
}
