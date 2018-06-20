package com.thienhoang.ehrm.service.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.EmployeeContracts;

public interface EmployeeContractService {
	List<EmployeeContracts> getAllContracts();
	List<EmployeeContracts> getAllContracts(Integer ma);	
	void addNewItem(EmployeeContracts e);
	void editItem(EmployeeContracts e);
	void deleteItem(EmployeeContracts e);
	EmployeeContracts findById(Integer ID);
}
