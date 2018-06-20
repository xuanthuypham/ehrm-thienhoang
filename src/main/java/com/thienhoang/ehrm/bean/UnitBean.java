package com.thienhoang.ehrm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.thienhoang.ehrm.model.Units;
import com.thienhoang.ehrm.service.interfaces.UnitService;

@ManagedBean(name="unitBean")
@RequestScoped
public class UnitBean {
	
	@ManagedProperty(value="#{unitService}")
	private UnitService unitService;
	
	private List<Units> list;


	public List<Units> getList() {
		list = (List<Units>)unitService.getAllUnit();
		return list;
	}

	public void setList(List<Units> list) {
		this.list = list;
	}

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}
	
}
