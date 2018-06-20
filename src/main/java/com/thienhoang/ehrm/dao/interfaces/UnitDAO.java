package com.thienhoang.ehrm.dao.interfaces;

import java.util.List;

import com.thienhoang.ehrm.model.Units;

public interface UnitDAO {
	List<Units> getList();
	Units findById(Integer ID);
}
