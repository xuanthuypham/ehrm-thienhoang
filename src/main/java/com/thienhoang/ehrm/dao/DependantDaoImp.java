package com.thienhoang.ehrm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.thienhoang.ehrm.dao.interfaces.DependantDAO;
import com.thienhoang.ehrm.dao.interfaces.ModelDAO;
import com.thienhoang.ehrm.model.EmployeeDependants;

@Repository("dependantDao")
public class DependantDaoImp extends ModelDAO implements DependantDAO {
	
	Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDependants> getList(Integer EMPLOYEE_ID) {
		// TODO Auto-generated method stub
		session = getSession();
		List<EmployeeDependants> list = null;
		try {
		Query que = session.createQuery("from EmployeeDependants as dep where dep.employeeRelatives.employees.employeeId = "+EMPLOYEE_ID);
		list = que.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void persist(EmployeeDependants entity) {
		// TODO Auto-generated method stub
		session = getSession();
		session.persist(entity);
	}

	@Override
	public EmployeeDependants FindById(Integer ID) {
		// TODO Auto-generated method stub
		session = getSession();
		EmployeeDependants e = (EmployeeDependants) session.get(EmployeeDependants.class,ID);
		return e;
	}

	@Override
	public void update(EmployeeDependants entity) {
		// TODO Auto-generated method stub
		session = getSession();
		session.update(entity);
	}

	@Override
	public void delete(EmployeeDependants entity) {
		// TODO Auto-generated method stub
		session = getSession();
		session.delete(entity);
	}

}
