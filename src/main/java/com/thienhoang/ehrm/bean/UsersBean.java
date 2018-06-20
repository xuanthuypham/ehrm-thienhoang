package com.thienhoang.ehrm.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.thienhoang.ehrm.dao.UsersDAO;
import com.thienhoang.ehrm.model.Users;



@ManagedBean(name="users_bean",eager = true)
@ApplicationScoped
public class UsersBean {
	//private List<Users> lst;
	private ListDataModel<Users> lst;

	public ListDataModel<Users> getLst() {
		List<Users> listt = new UsersDAO().getList();
		lst= new ListDataModel<Users>(listt); 
		return lst;
	}

//	public void setLst(List<Users> lst) {
//		this.lst = lst;
//	}
	public static void main(String[] args) {
		ListDataModel<Users> lst = new UsersBean().getLst();
		for(Users us : lst)
		{
			System.out.println(us.toString());
		}
	}
}
