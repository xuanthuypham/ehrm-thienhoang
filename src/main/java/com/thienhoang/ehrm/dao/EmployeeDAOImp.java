package com.thienhoang.ehrm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.thienhoang.ehrm.dao.interfaces.EmployeeDAO;
import com.thienhoang.ehrm.dao.interfaces.ModelDAO;
import com.thienhoang.ehrm.model.Employees;

@Repository("employeeDao")
public class EmployeeDAOImp extends ModelDAO implements EmployeeDAO {
	
	Session session;
	
	@Override
	@SuppressWarnings({ "unchecked" })		
	public List<Employees> getList(String keyword) {
		// TODO Auto-generated method stub
		List<Employees> list= null;
		String hql;
        try
        {
        	list = new ArrayList<Employees>();

        	session = getSession();
        	if (keyword == null) {
        		 hql = "from Employees";        		
        	} else {
        		 hql ="from Employees where employeeId like '%"+keyword+"%' or firstName like '%"+keyword+"%' or lastName like '%"+keyword+"%'";        		
        	}
	        Query que = session.createQuery(hql);
	        list = que.list();        	
        }
        catch  (HibernateException e) {
        	 e.printStackTrace();
        }
        return list;		
	}

	@Override
	public void persist(Employees e) {
		// TODO Auto-generated method stub
		session = getSession();
		session.persist(e);
	}

	@Override
	public Employees FindById(Integer ID) {
		// TODO Auto-generated method stub
		session = getSession();
		Employees e = (Employees) session.get(Employees.class, ID);
		return e;
	}

	@Override
	public void update(Employees e) {
		// TODO Auto-generated method stub
		session = getSession();
		session.update(e);
	}

	@Override
	public void delete(Employees e) {
		// TODO Auto-generated method stub
		session = getSession();
		session.delete(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> getListAdvance(Integer companySearch, String nameSearch, Integer statusSearch,
			Integer genderSearch) {
		// TODO Auto-generated method stub
		String hql = null;
		List<Employees> list = null;
        try
        {
        	list = new ArrayList<Employees>();
        	session = getSession();
        	if ( (companySearch ==0) && (nameSearch == null) && (statusSearch == 2) && (genderSearch == 0)) {
       		 hql = "from Employees";        		
        	} else if ((companySearch == 0) && (nameSearch == null) && (statusSearch == 2) && (genderSearch != 0)) {
        		hql ="from Employees where masterDatasByGenderId = "+genderSearch;        		        		
        	} else if ((companySearch == 0) && (nameSearch == null) && (statusSearch != 2) && (genderSearch == 0)) {
        		hql ="from Employees where active = "+statusSearch;        		
        	} else if ((companySearch == 0) && (nameSearch == null) && (statusSearch != 2) && (genderSearch != 0)) {
        		hql ="from Employees where masterDatasByGenderId = "+genderSearch+" and active = "+statusSearch;        		        		        		  		
        	} else if ((companySearch == 0) && (nameSearch != null) && (statusSearch == 2) && (genderSearch == 0)) {
        		 hql ="from Employees where firstName like '%"+nameSearch+"%'";        		
        	} else if ((companySearch == 0) && (nameSearch != null) && (statusSearch == 2) && (genderSearch != 0)) {
        		hql ="from Employees where masterDatasByGenderId = "+genderSearch+" and firstName like '%"+nameSearch+"%'";        		        		        		
        	} else if ((companySearch == 0) && (nameSearch != null) && (statusSearch != 2) && (genderSearch ==0)) {
        		hql ="from Employees where active = "+statusSearch+" and firstName like '%"+nameSearch+"%'";        		        		
        	} else if ((companySearch == 0) && (nameSearch != null) && (statusSearch != 2) && (genderSearch != 0)) {
        		hql ="from Employees where active = "+statusSearch+" and firstName like '%"+nameSearch+"%' and masterDatasByGenderId = "+genderSearch;        		        		     		
        	} else if ((companySearch != 0) && (nameSearch == null) && (statusSearch == 2)&& (genderSearch == 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch;
        	} else if ((companySearch != 0) && (nameSearch == null) && (statusSearch == 2)&& (genderSearch != 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.masterDatasByGenderId = "+genderSearch;
        	} else if ((companySearch != 0) && (nameSearch == null) && (statusSearch != 2)&& (genderSearch == 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.active = "+statusSearch;
        	} else if ((companySearch != 0) && (nameSearch == null) && (statusSearch != 2)&& (genderSearch != 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.active = "+statusSearch+" and e.masterDatasByGenderId = "+genderSearch;       		
        	} else if ((companySearch != 0) && (nameSearch != null) && (statusSearch == 2)&& (genderSearch == 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.firstName like '%"+nameSearch+"%'";    		
        	} else if ((companySearch != 0) && (nameSearch != null) && (statusSearch == 2)&& (genderSearch != 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.firstName like '%"+nameSearch+"%' and e.masterDatasByGenderId ="+genderSearch;    		
        	} else if ((companySearch != 0) && (nameSearch != null) && (statusSearch != 2)&& (genderSearch == 0)) {
        		hql = "select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.firstName like '%"+nameSearch+"%' and e.active = "+statusSearch;    		      		
        	} else {
        		 hql ="select e from EmployeeUnits eu INNER JOIN eu.employees as e INNER JOIN eu.units as u where u.unitId = "+companySearch+" and e.masterDatasByGenderId = "+genderSearch+" and e.active = "+statusSearch+" and e.firstName like '%"+nameSearch+"%'";
        	}
	        Query que = session.createQuery(hql);
	        list = que.list();        	
        }
        catch  (HibernateException e) {
        	 e.printStackTrace();
        }
        return list;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> getListDESC() {
		// TODO Auto-generated method stub
		List<Employees> list= null;
		String hql;
        try
        {
        	list = new ArrayList<Employees>();
        	session = getSession();
        	hql = "from Employees order by identifyCompany DESC";        		
	        Query que = session.createQuery(hql);
	        list = que.list();   
        }
        catch  (HibernateException e) {
        	 e.printStackTrace();
        }
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> getListAttendanceDESC() {
		// TODO Auto-generated method stub
		List<Employees> list= null;
		String hql;
        try
        {
        	list = new ArrayList<Employees>();
        	session = getSession();
        	hql = "from Employees order by attendancecode DESC";        		
	        Query que = session.createQuery(hql);
	        list = que.list();   
        }
        catch  (HibernateException e) {
        	 e.printStackTrace();
        }
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employees find8Id(String ID) {
		List<Employees> list = null ;
		String hql;
			session = getSession();
        	hql = "from Employees where identifyCompany = '"+ID+"'";      
        	Query que = session.createQuery(hql);
        	list = (List<Employees>)que.list();
    		if (list.isEmpty()) {
    			return null;
    		} else {
    			return list.get(0);
    		}
	}
}
