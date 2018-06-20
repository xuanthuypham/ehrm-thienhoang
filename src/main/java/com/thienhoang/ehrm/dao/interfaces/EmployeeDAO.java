package com.thienhoang.ehrm.dao.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.Employees;

public interface EmployeeDAO {
	 List<Employees> getListAdvance(Integer companySearch, String nameSearch, Integer statusSearch, Integer genderSearch);
	 List<Employees> getList(String keyword);
	 void persist(Employees e);
	 Employees FindById(Integer ID);
	 List<Employees> getListDESC();
	 List<Employees> getListAttendanceDESC();
	 void update(Employees e);
	 void delete(Employees e);	
	 Employees find8Id(String ID);
}
