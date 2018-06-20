package com.thienhoang.ehrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thienhoang.ehrm.dao.interfaces.ReasonsDAO;
import com.thienhoang.ehrm.model.Reasons;
import com.thienhoang.ehrm.service.interfaces.ReasonService;

@Service("reasonService")
@Transactional
public class ReasonServiceImp implements ReasonService{

	@Autowired
	private ReasonsDAO reasonDao;
	
	@Override
	public List<Reasons> getList() {
		// TODO Auto-generated method stub
		return reasonDao.getList();
	}

}
