package com.thienhoang.ehrm.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import com.thienhoang.ehrm.model.Projects;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.model.MasterDatas;

import org.hibernate.cfg.Configuration;

public class ProjectsDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<Projects> getList()
	{
		List<Projects> list= null;
	        try
	        {
	        	list = new ArrayList<Projects>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from Projects";
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
	
	public  List<Projects> getSearch(String code, String name, int status)
	{
		List<Projects> list= null;
	        try
	        {
	        	String hql;
	        	if(code == null)
	        	{
	        		code="";
	        	}
	        	if(name == null)
	        	{
	        		name="";
	        	}
	        	if(status == 744 || status == 745 || status == 746)
	        	{
	        		 hql ="from Projects where projectCode like '%"+code+"%' and projectName like '%"+name+"%' and status = "+status;
	        		 
	        	}
	        	else
	        	{
	        		 hql ="from Projects where projectCode like '%"+code+"%' and projectName like '%"+name+"%'";
	        	}
	        	list = new ArrayList<Projects>();
	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        
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
	public  List<Projects> getListActive()
	{
		List<Projects> list= null;
	        try
	        {
	        	list = new ArrayList<Projects>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from Projects where STATUS=744";
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
	public void insert(Projects pr){
		Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(pr);
        transaction.commit();
//        session.close();
    }
 
	 public void delete(Projects pr){
		 	Session session = getSession();
	        Transaction transaction = session.beginTransaction();
	        session.delete(pr);
	        transaction.commit();
//	        session.close();
	    }
	 public void update(Projects pr){
		Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(pr);
        transaction.commit();
//        session.close();
    }
	 public Projects search(int id) {
		 Projects pr = null;
	       try
	       {
	    	   Session session = getSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from Projects where projectId = "+id;
		        Query que = session.createQuery(hql);
		        pr = (Projects) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return pr;
	    }
	public static void main(String[] args) {
		String xxx = null;
		List<Projects> lst = new ProjectsDAO().getSearch(xxx,xxx,0);
		for(Projects cd : lst)
		{
			System.out.println(cd.getProjectCode() +"=============>"+cd.getProjectName());
		}
		System.out.println(lst.size());
		
//		MasterDatas mtd = new MasterDatas(744);
//		Projects pr = new Projects("test", "kiem tra", "them moi project", mtd);
//		new ProjectsDAO().insert(pr);
		
//		Projects pr = new ProjectsDAO().search(157);
//		pr.setDescription("test update");
//		new ProjectsDAO().delete(pr);
//		Projects prr = new ProjectsDAO().search(156);
//		System.out.println(prr.getDescription());
				
	}
	//==========================================================================================
	public Employees getEmployeeById(int id)
	{
		Employees us = new Employees();
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
        String hql ="from Employees where employeeId="+id;
        Query que = session.createQuery(hql);
        
        us = (Employees) que.uniqueResult();
        transaction.commit();
		return us;
	}
	public  List<Employees> listEmp()
	{
		List<Employees> list= null;
	        try
	        {
	        	list = new ArrayList<Employees>();

	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from Employees";
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
