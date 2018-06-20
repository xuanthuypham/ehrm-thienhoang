package com.thienhoang.ehrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thienhoang.ehrm.dao.interfaces.EmployeeContractDAO;
import com.thienhoang.ehrm.model.EmployeeContracts;
import com.thienhoang.ehrm.service.interfaces.EmployeeContractService;

@Service("eContractService")
@Transactional
public class EmployeeContractServiceImp implements EmployeeContractService {

	@Autowired
	private EmployeeContractDAO employeeContractDao;
	
	@Override
	public List<EmployeeContracts> getAllContracts() {
		// TODO Auto-generated method stub
		return employeeContractDao.getList();
	}

	@Override
	public List<EmployeeContracts> getAllContracts(Integer ma) {
		// TODO Auto-generated method stub
		return employeeContractDao.listOf(ma);
	}

	@Override
	public void addNewItem(EmployeeContracts e) {
		// TODO Auto-generated method stub
		this.employeeContractDao.persistContract(e);
	}

	@Override
	public void editItem(EmployeeContracts e) {
		// TODO Auto-generated method stub
		this.employeeContractDao.updateContract(e);
	}

	@Override
	public void deleteItem(EmployeeContracts e) {
		// TODO Auto-generated method stub
		this.employeeContractDao.deleteContract(e);
	}

	@Override
	public EmployeeContracts findById(Integer ID) {
		// TODO Auto-generated method stub
		EmployeeContracts con = employeeContractDao.FindById(ID);
		return con;
	}

}
