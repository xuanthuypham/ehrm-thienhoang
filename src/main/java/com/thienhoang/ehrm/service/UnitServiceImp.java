package com.thienhoang.ehrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thienhoang.ehrm.dao.interfaces.UnitDAO;
import com.thienhoang.ehrm.model.Units;
import com.thienhoang.ehrm.service.interfaces.UnitService;

@Service("unitService")
@Transactional
public class UnitServiceImp implements UnitService {

	@Autowired
	private UnitDAO unitDao;
	
	@Override
	public List<Units> getAllUnit() {
		// TODO Auto-generated method stub
		List<Units> list = unitDao.getList();
		return list;
	}

	@Override
	public Units finById(Integer ID) {
		// TODO Auto-generated method stub
		return unitDao.findById(ID);
	}

}
