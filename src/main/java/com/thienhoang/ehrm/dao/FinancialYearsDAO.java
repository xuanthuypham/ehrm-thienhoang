package com.thienhoang.ehrm.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import com.thienhoang.ehrm.model.FinancialYears;
import com.thienhoang.ehrm.model.MasterDatas;

public class FinancialYearsDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<FinancialYears> getList()
	{
		List<FinancialYears> list= null;
	        try
	        {
	        	list = new ArrayList<FinancialYears>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from FinancialYears";
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
	public static void main(String[] args) {
		List<FinancialYears> lst = new FinancialYearsDAO().getList();
		for(FinancialYears fn :lst)
		{
			System.out.println(fn);
		}
	}
}
