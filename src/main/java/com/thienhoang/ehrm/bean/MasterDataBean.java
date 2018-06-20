package com.thienhoang.ehrm.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import com.thienhoang.ehrm.dao.MasterDatasDAO;
import com.thienhoang.ehrm.model.MasterDatas;

@ManagedBean(name="masterDataBean")
@ApplicationScoped
public class MasterDataBean {

	private List<MasterDatas> list;

	public List<MasterDatas> getList(int TYPE_ID) {
		list = new MasterDatasDAO().getList(TYPE_ID);
		return list;
	}

	public void setList(List<MasterDatas> list) {
		this.list = list;
	}
	
}
