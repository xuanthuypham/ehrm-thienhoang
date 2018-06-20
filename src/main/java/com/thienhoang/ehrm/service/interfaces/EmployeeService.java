package com.thienhoang.ehrm.service.interfaces;

import java.util.List;
import com.thienhoang.ehrm.model.Employees;

public interface EmployeeService {
	List<Employees> getAllEmployees(String keyword);
	List<Employees> getAllEmployeeAdvance(Integer companySearch, String nameSearch, Integer statusSearch, Integer genderSearch);
	void addEmployee(Employees e);
	String generateEmployee8Id();
	String generateAttendanceCode();
	void editEmployee(Employees e);
	void deleteEmployee(Employees e);
	Employees findById(Integer ID);
	boolean find8ID(String ID);
}
