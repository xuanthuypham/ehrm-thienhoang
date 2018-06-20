package com.thienhoang.ehrm.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import com.thienhoang.ehrm.service.interfaces.EmployeeRelativeService;
import com.thienhoang.ehrm.utils.SessionUtil;
import com.thienhoang.ehrm.model.EmployeeRelatives;
import com.thienhoang.ehrm.model.Employees;

@ManagedBean(name="employeeRelativeBean")
@RequestScoped
public class EmployeeRelativeBean {
	
	@ManagedProperty(value="#{relativeService}")
	private EmployeeRelativeService employeeRelativeService;
	
	private List<EmployeeRelatives> list;
	private Employees employee;
	
	public EmployeeRelativeService getEmployeeRelativeService() {
		return employeeRelativeService;
	}

	public void setEmployeeRelativeService(EmployeeRelativeService employeeRelativeService) {
		this.employeeRelativeService = employeeRelativeService;
	}

	public List<EmployeeRelatives> getList() {
		HttpSession session = SessionUtil.getSession();
		employee = (Employees) session.getAttribute("employee");
		list = (List<EmployeeRelatives>) employeeRelativeService.getEmployeeRelatives(employee.getEmployeeId());
		return list;
	}

	public void setList(List<EmployeeRelatives> list) {
		this.list = list;
	}
	
}
