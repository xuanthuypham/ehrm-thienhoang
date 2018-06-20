package com.thienhoang.ehrm.dao.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.EmployeeRelatives;

public interface EmployeeRelativesDAO {
	EmployeeRelatives findById(Integer ID);
	List<EmployeeRelatives> getAll(Integer ID);
}
