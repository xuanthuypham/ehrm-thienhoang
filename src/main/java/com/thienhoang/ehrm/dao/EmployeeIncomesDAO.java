package com.thienhoang.ehrm.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import com.thienhoang.ehrm.model.EmployeeIncomes;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.model.MasterDatas;
import com.thienhoang.ehrm.model.Projects;

import org.hibernate.cfg.Configuration;
public class EmployeeIncomesDAO {
	private SessionFactory sessionFactory ;
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
//		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings({ "unchecked" })
	public  List<EmployeeIncomes> getList(int IncomeId, int EmpId)
	{
		List<EmployeeIncomes> list= null;
	        try
	        {
	        	list = new ArrayList<EmployeeIncomes>();

	        	Session session = getSession(); //14202 14557 14944
	        	Transaction transaction = session.beginTransaction();
		        String hql ="from EmployeeIncomes where PERIOD_ID = "+IncomeId +" and EMPLOYEE_ID = "+EmpId;
		        Query que = session.createQuery(hql);
//		        que.setFirstResult(start);
//		        que.setMaxResults(next);
		        list = que.list();
		        transaction.commit();
		        session.close();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	public void insert(EmployeeIncomes pr){
		Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(pr);
        transaction.commit();
//        session.close();
    }
 
	 public void delete(EmployeeIncomes pr){
		 	Session session = getSession();
	        Transaction transaction = session.beginTransaction();
	        session.delete(pr);
	        transaction.commit();
//	        session.close();
	    }
	 public void update(EmployeeIncomes pr){
		Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(pr);
        transaction.commit();
        session.close();
    }
	 public static void main(String[] args) {
		 
		 List<EmployeeIncomes> lst = new EmployeeIncomesDAO().getList(89,3522);
		 System.out.println(lst.size());
		 for(EmployeeIncomes ei : lst)
		 {
//			 ei.setAffectValue(String.valueOf(2000000+100000*i));
//			 ei.setPayValue(String.valueOf(2000000+100000*i));
//			 ei.setCalculatedValue(String.valueOf(2000000+100000*i));
//			 ei.setCalculatedValue(String.valueOf(2000000+100000*i));
//			 ei.setIncomeValue(String.valueOf(2000000+100000*i));
//			 if(!ei.getCalculatedAmount().equals(null))
//			 {
//				 ei.setCalculatedAmount(String.valueOf(2000000+200000*i));
//				 new EmployeeIncomesDAO().update(ei);
//				 System.out.println("ok "+i);
//				 
//			 }
//			 i++;
			 
			 
			 System.out.println(ei.getEmployeeIncomeId() +"   "+ei.getIncomes().getIncomeId());
		 }
	}
}
