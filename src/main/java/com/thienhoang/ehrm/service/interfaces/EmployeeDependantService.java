package com.thienhoang.ehrm.service.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.EmployeeDependants;

public interface EmployeeDependantService {
	List<EmployeeDependants> getAllDependant(Integer EMPLOYEE_ID);
	EmployeeDependants findDependant(Integer ID);
	void addDependant(EmployeeDependants e);
	void updateDependant(EmployeeDependants e);
	void deleteDependant(EmployeeDependants e);
}
