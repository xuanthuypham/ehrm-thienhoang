package com.thienhoang.ehrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thienhoang.ehrm.dao.interfaces.EmployeeDAO;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.service.interfaces.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public List<Employees> getAllEmployees(String keyword) {
		// TODO Auto-generated method stub
		return employeeDao.getList(keyword);
	}

	@Override
	public List<Employees> getAllEmployeeAdvance(Integer companySearch, String nameSearch, Integer statusSearch,
			Integer genderSearch) {
		// TODO Auto-generated method stub
		return employeeDao.getListAdvance(companySearch, nameSearch, statusSearch, genderSearch);
	}

	@Override
	public void addEmployee(Employees e) {
		// TODO Auto-generated method stub
		employeeDao.persist(e);
	}

	@Override
	public String generateEmployee8Id() {
		// TODO Auto-generated method stub
		Integer employeeId = Integer.parseInt(employeeDao.getListDESC().get(0).getIdentifyCompany())+1;
		return Integer.toString(employeeId);
	}

	@Override
	public String generateAttendanceCode() {
		// TODO Auto-generated method stub
		String attendanceCode = employeeDao.getListAttendanceDESC().get(0).getAttendancecode();
		Integer attendanceCodeInt = Integer.parseInt(attendanceCode);
		if (attendanceCodeInt < 100000000) {
			attendanceCodeInt = attendanceCodeInt + 1;
		}
		return Integer.toString(attendanceCodeInt);
	}

	@Override
	public void editEmployee(Employees e) {
		// TODO Auto-generated method stub
		employeeDao.update(e);
	}

	@Override
	public void deleteEmployee(Employees e) {
		// TODO Auto-generated method stub
		employeeDao.delete(e);
	}

	@Override
	public Employees findById(Integer ID) {
		// TODO Auto-generated method stub
		Employees e = employeeDao.FindById(ID);
		return e;
	}

	@Override
	public boolean find8ID(String ID) {
		// TODO Auto-generated method stub
		if(employeeDao.find8Id(ID)!= null) {
			return true;
		}else {
			return false;
		}
	}
}
