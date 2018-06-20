package com.thienhoang.ehrm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.thienhoang.ehrm.model.EmployeeDependants;
import com.thienhoang.ehrm.model.EmployeeRelatives;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.service.interfaces.EmployeeDependantService;
import com.thienhoang.ehrm.service.interfaces.EmployeeRelativeService;
import com.thienhoang.ehrm.utils.SessionUtil;

@ManagedBean(name="dependantBean")
@RequestScoped
public class EmployeeDependantBean {
	
	@ManagedProperty(value="#{dependantService}")
	private EmployeeDependantService dependantService;
	
	@ManagedProperty(value="#{relativeService}")
	private EmployeeRelativeService relativeService;
	
	private ArrayList<EmployeeDependants> list = null;
	private EmployeeDependants dependant;
	private Integer editDependantId;
	private Integer employeeRelative;
	private Date startDate;
	private Date endDate;
	private Employees employee;
	
	
	public EmployeeDependantService getDependantService() {
		return dependantService;
	}

	public void setDependantService(EmployeeDependantService dependantService) {
		this.dependantService = dependantService;
	}
	
	public EmployeeRelativeService getRelativeService() {
		return relativeService;
	}

	public void setRelativeService(EmployeeRelativeService relativeService) {
		this.relativeService = relativeService;
	}

	public Integer getEditDependantId() {
		return editDependantId;
	}

	public void setEditDependantId(Integer editDependantId) {
		this.editDependantId = editDependantId;
	}
	
	public ArrayList<EmployeeDependants> getList() {
		HttpSession session = SessionUtil.getSession();
		employee = (Employees)session.getAttribute("employee");
		List<EmployeeDependants> lst = dependantService.getAllDependant(employee.getEmployeeId());
		list = new ArrayList<EmployeeDependants>(lst);
		return list;
	}

	public void setList(ArrayList<EmployeeDependants> list) {
		this.list = list;
	}

	public EmployeeDependants getDependant() {
		return dependant;
	}

	public void setDependant(EmployeeDependants dependant) {
		this.dependant = dependant;
	}
	
	public Integer getEmployeeRelative() {
		return employeeRelative;
	}

	public void setEmployeeRelative(Integer employeeRelative) {
		this.employeeRelative = employeeRelative;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public void addDependant() {
		EmployeeRelatives rel = relativeService.findEmployeeRelative(employeeRelative);
		EmployeeDependants dep = new EmployeeDependants(rel,startDate,endDate);
		dependantService.addDependant(dep);
	}
	public void updateDependant() {
		EmployeeRelatives rel = relativeService.findEmployeeRelative(employeeRelative);
		EmployeeDependants dep = dependantService.findDependant(editDependantId);
		dep.setEmployeeRelatives(rel);
		dep.setStartDate(startDate);
		dep.setEndDate(endDate);
		try {
		dependantService.updateDependant(dep);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	public void deleteDependant(Integer ID) {
		try {
		EmployeeDependants dep = dependantService.findDependant(ID);
		dependantService.deleteDependant(dep);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
