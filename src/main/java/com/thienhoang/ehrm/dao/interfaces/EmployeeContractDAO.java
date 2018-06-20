package com.thienhoang.ehrm.dao.interfaces;

import java.util.List;
import com.thienhoang.ehrm.model.EmployeeContracts;

public interface EmployeeContractDAO {

	 List<EmployeeContracts> getList();
	 List<EmployeeContracts> listOf(Integer ma);
	 void persistContract(EmployeeContracts entity);
	 EmployeeContracts FindById(Integer ID);
	 void updateContract(EmployeeContracts entity);
	 void deleteContract(EmployeeContracts entity);	
}
