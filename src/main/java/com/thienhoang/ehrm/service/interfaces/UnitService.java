package com.thienhoang.ehrm.service.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.Units;

public interface UnitService {
	List<Units> getAllUnit();
	Units finById(Integer ID);
}
