package com.thienhoang.ehrm.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import com.thienhoang.ehrm.model.ProjectDefaults;
import com.thienhoang.ehrm.model.Projects;

import org.hibernate.cfg.Configuration;

public class ProjectDefaultDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<ProjectDefaults> getList(int id)
	{
		List<ProjectDefaults> list= null;
	        try
	        {
	        	list = new ArrayList<ProjectDefaults>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from ProjectDefaults where EMPLOYEE_ID = "+id+" order by PROJECT_ID";
		        Query que = session.createQuery(hql);
//		        que.setFirstResult(start);
//		        que.setMaxResults(next);
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
	public void insert(ProjectDefaults prd){
		Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(prd);
        transaction.commit();
//        session.close();
    }
	
	public static void main(String[] args) {
		List<ProjectDefaults> list= new ProjectDefaultDAO().getList(3509);
		for (ProjectDefaults br : list)
		{
			System.out.println(br.getProjects().getProjectId());
		}
		System.out.println(list.size());
	}
}
