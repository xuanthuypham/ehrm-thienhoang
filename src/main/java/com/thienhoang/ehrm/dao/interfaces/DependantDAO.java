package com.thienhoang.ehrm.dao.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.EmployeeDependants;

public interface DependantDAO {
	 List<EmployeeDependants> getList(Integer EMPLOYEE_ID);
	 void persist(EmployeeDependants entity);
	 EmployeeDependants FindById(Integer ID);
	 void update(EmployeeDependants entity);
	 void delete(EmployeeDependants entity);	
}
