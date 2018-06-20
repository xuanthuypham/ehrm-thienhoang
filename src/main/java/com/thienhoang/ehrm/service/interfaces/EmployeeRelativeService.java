package com.thienhoang.ehrm.service.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.EmployeeRelatives;

public interface EmployeeRelativeService {
	EmployeeRelatives findEmployeeRelative(Integer ID);
	List<EmployeeRelatives> getEmployeeRelatives(Integer ID);
}
