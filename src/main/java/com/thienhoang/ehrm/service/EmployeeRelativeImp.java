package com.thienhoang.ehrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thienhoang.ehrm.dao.interfaces.EmployeeRelativesDAO;
import com.thienhoang.ehrm.model.EmployeeRelatives;
import com.thienhoang.ehrm.service.interfaces.EmployeeRelativeService;

@Service("relativeService")
public class EmployeeRelativeImp implements EmployeeRelativeService {

	@Autowired
	private EmployeeRelativesDAO relativeDao;
	
	@Override
	@Transactional
	public EmployeeRelatives findEmployeeRelative(Integer ID) {
		// TODO Auto-generated method stub
		return relativeDao.findById(ID);
	}

	@Override
	@Transactional
	public List<EmployeeRelatives> getEmployeeRelatives(Integer ID) {
		// TODO Auto-generated method stub
		return relativeDao.getAll(ID);
	}

}
