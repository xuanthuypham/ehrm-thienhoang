package com.thienhoang.ehrm.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.Transaction;
import com.thienhoang.ehrm.model.MasterDatas;


import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

@SuppressWarnings("deprecation")
public class MasterDatasDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
		//return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<MasterDatas> getList(int TYPE_ID)
	{
		List<MasterDatas> list= null;
	        try
	        {
	        	list = new ArrayList<MasterDatas>();

//	        	Configuration configuration =  new Configuration().configure();
//	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
//	        	Session session = sessionFactory.openSession();
	        	Session session = getSession();
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from MasterDatas where masterDataTypes= "+TYPE_ID;
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
	
	public MasterDatas findById(Integer ID) {
		 MasterDatas mData = null;
	       try
	       {
	        	Session session = getSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from MasterDatas where masterDataId = "+ID;
		        Query que = session.createQuery(hql);
		        mData = (MasterDatas) que.uniqueResult();
		        transaction.commit();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return mData;	
		
	}
	
	public static void main(String[] args) {
		 List<MasterDatas> lst = new  MasterDatasDAO().getList(5);
		 if(lst != null)
		 {
			 for(MasterDatas md :lst)
			 {
				 //System.out.println(md.toString());
			 }
		 }
	}
}
