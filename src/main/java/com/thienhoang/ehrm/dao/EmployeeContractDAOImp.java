package com.thienhoang.ehrm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.thienhoang.ehrm.dao.interfaces.EmployeeContractDAO;
import com.thienhoang.ehrm.dao.interfaces.ModelDAO;
import com.thienhoang.ehrm.model.EmployeeContracts;

@Repository("employeeContractDao")
public class EmployeeContractDAOImp extends ModelDAO implements EmployeeContractDAO {

	Session session;
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<EmployeeContracts> getList() {
		// TODO Auto-generated method stub
		List<EmployeeContracts> list = null;
        try
        {
        	list = new ArrayList<EmployeeContracts>();

        	session = getSession();
        //	Transaction transaction = session.beginTransaction();
	        String hql ="from EmployeeContracts";
	        Query que = session.createQuery(hql);
	        list = que.list();
	    //    transaction.commit();
	     
        }
        catch  (HibernateException e) {
        	 e.printStackTrace();
        }
        return list;
	}

	@Override
	public void persistContract(EmployeeContracts entity) {
		// TODO Auto-generated method stub
		session = getSession();
		session.persist(entity);
	}

	@Override
	public void updateContract(EmployeeContracts entity) {
		// TODO Auto-generated method stub
		session = getSession();
		session.update(entity);
	}

	@Override
	public void deleteContract(EmployeeContracts entity) {
		// TODO Auto-generated method stub
		session = getSession();
		session.delete(entity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeContracts> listOf(Integer ma) {
		// TODO Auto-generated method stub
		List<EmployeeContracts> list = null;
        try
        {
        	list = new ArrayList<EmployeeContracts>();

        	session = getSession();
        //	Transaction transaction = session.beginTransaction();
	        String hql ="from EmployeeContracts as con where con.employees.employeeId ="+ma;
	        Query que = session.createQuery(hql);
	        list = que.list();
	    //    transaction.commit();
	     
        }
        catch  (HibernateException e) {
        	 e.printStackTrace();
        }
        return list;
	}

	@Override
	public EmployeeContracts FindById(Integer ID) {
		// TODO Auto-generated method stub
		session = getSession();
		EmployeeContracts con = (EmployeeContracts) session.get(EmployeeContracts.class, ID);
		return con;
	}

}
