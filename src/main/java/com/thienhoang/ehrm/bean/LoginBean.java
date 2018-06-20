package com.thienhoang.ehrm.bean;
import javax.servlet.http.HttpSession;
import com.thienhoang.ehrm.dao.UsersDAO;
import com.thienhoang.ehrm.model.Users;
import com.thienhoang.ehrm.utils.SessionUtil;
import com.thienhoang.ehrm.model.Employees;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
@ManagedBean(name="login_bean",eager = true)
@RequestScoped
public class LoginBean {
	private String username;
	private String pass;
	private String link = "";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String Login()
	{
		boolean ck = true;
		if(username.length()==0 || username==null)
		{
			ck = false;
			FacesMessage message = new FacesMessage("Chưa nhập username");
			FacesContext.getCurrentInstance().addMessage("loginform:uname", message);
			return "login.xhtml";
		}
		if(pass.length()==0 || pass==null)
		{
			ck= false;
			FacesMessage message = new FacesMessage("Chưa nhập password");
			FacesContext.getCurrentInstance().addMessage("loginform:pass", message);
			this.link = "login.xhtml";
		}
		if(ck)
		{
			try
			{
				Users us = new UsersDAO().getUserByUsename(username);
				if(us==null)
				{
					FacesMessage message = new FacesMessage("Không tồn tại tài khoản");
					FacesContext.getCurrentInstance().addMessage("loginform:uname", message);
					this.link = "login.xhtml";
				}
				else
				{
					if(us.getPassword().equals(pass))
					{
						if(us.isActive())
						{
							HttpSession session = SessionUtil.getSession();
							Employees emp = us.getEmployees();
							session.setAttribute("user", emp);
							this.link="project/project.xhtml?faces-redirect = true";						
						}
						else
						{
							
							FacesMessage message = new FacesMessage("Permision deny");
							FacesContext.getCurrentInstance().addMessage("loginform:err_notify", message);
							this.link = "login.xhtml";
						}
					}
					else
					{
						FacesMessage message = new FacesMessage("Sai password");
						FacesContext.getCurrentInstance().addMessage("loginform:pass", message);
						this.link = "login.xhtml";
					}
				}
			}
			catch(Exception e)
			{
				FacesMessage message = new FacesMessage("Permision deny");
				FacesContext.getCurrentInstance().addMessage("loginform:err_notify", message);
				this.link = "login.xhtml";
			}
		}
		return link;
	}
	public String Logout() {
//		HttpSession session = SessionUtil.getSession();
//		session.invalidate();
		return "login.xhtml?faces-redirect = true"; 
	}
	public String getUser()
	{
		Employees emp = SessionUtil.getUser();
		String full_name = emp.getLastName() +" "+emp.getMiddleName() +" "+emp.getFirstName();
		
		return full_name; 
	}
	public String vv()
	{
		// ham nay de xoa session :((
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		
		return ""; 
	}
}
