package com.thienhoang.ehrm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.thienhoang.ehrm.dao.interfaces.EmployeeRelativesDAO;
import com.thienhoang.ehrm.dao.interfaces.ModelDAO;
import com.thienhoang.ehrm.model.EmployeeRelatives;

@Repository("relativeDao")
public class EmployeeRelativesDAOImp extends ModelDAO implements EmployeeRelativesDAO {
	
	Session session;
	
	@Override
	public EmployeeRelatives findById(Integer ID) {
		// TODO Auto-generated method stub
		session = getSession();
		EmployeeRelatives e = (EmployeeRelatives) session.get(EmployeeRelatives.class, ID);
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeRelatives> getAll(Integer ID) {
		// TODO Auto-generated method stub
		List<EmployeeRelatives> lst = null;
		session = getSession();
		try {	
			Query que = session.createQuery("from EmployeeRelatives as rel where rel.employees.employeeId = "+ID);
			lst = que.list();
		} catch(HibernateException e) {
			e.printStackTrace();
		}
		return lst;
	}

}
