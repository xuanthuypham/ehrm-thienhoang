package com.thienhoang.ehrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thienhoang.ehrm.dao.interfaces.DependantDAO;
import com.thienhoang.ehrm.model.EmployeeDependants;
import com.thienhoang.ehrm.service.interfaces.EmployeeDependantService;

@Service("dependantService")
@Transactional
public class EmployeeDependantServiceImp implements EmployeeDependantService{

	private List<EmployeeDependants> list = null;
	
	@Autowired
	private DependantDAO dependantDao;
	
	@Override
	public List<EmployeeDependants> getAllDependant(Integer EMPLOYEE_ID) {
		// TODO Auto-generated method stub
		list = dependantDao.getList(EMPLOYEE_ID);
		return list;
	}

	@Override
	public void addDependant(EmployeeDependants e) {
		// TODO Auto-generated method stub
		this.dependantDao.persist(e);
	}

	@Override
	public void updateDependant(EmployeeDependants e) {
		// TODO Auto-generated method stub
		this.dependantDao.update(e);
	}

	@Override
	public void deleteDependant(EmployeeDependants e) {
		// TODO Auto-generated method stub
		this.dependantDao.delete(e);
	}

	@Override
	public EmployeeDependants findDependant(Integer ID) {
		// TODO Auto-generated method stub
		EmployeeDependants e = dependantDao.FindById(ID);
		return e;
	}

}
