package com.thienhoang.ehrm.bean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletResponse;

import com.thienhoang.ehrm.dao.ProjectDefaultDAO;
import com.thienhoang.ehrm.dao.ProjectsDAO;
import com.thienhoang.ehrm.model.ProjectDefaults;
import com.thienhoang.ehrm.model.Projects;
import com.thienhoang.ehrm.utils.SessionUtil;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.model.MasterDatas;


@ManagedBean(name="projects_bean",eager = true)
@RequestScoped
public class ProjectsBean {
	private ListDataModel<Projects> lst =null; // get all projects
	private int i=0; // STT
	private List<Projects> LstActive = null; // get all actived projects
	private List<Integer> LstChecked = null; // get all project_default
	private Projects pro = new Projects();
	private MasterDatas mt = new MasterDatas();
	// phan sau la cac tham so tim kiem
	private String code = null;
	private String name = null;
	private int status = 0;
	private String arr[];
	//===========================================================================================
	public void setLst(ListDataModel<Projects> lst) {
		this.lst = lst;
	}

	public ListDataModel<Projects> getLst() {
		try
		{
			List<Projects> listt = new ProjectsDAO().getSearch(code, name, status);
			this.lst = null;
			this.lst= new ListDataModel<Projects>(listt); 
		}
		catch(Exception e)
		{
			
		}
		return lst;
	}
	//===========================================================================================
	public String showAll()
	{
		this.code = null;
		this.name = null;
		this.status= 0;
		return "project/project.xhtml";
	}
	//===========================================================================================
	public String search()
	{
		return "project/project.xhtml";
	}
	//===========================================================================================
	public void setI(int i) {
		this.i = i;
	}

	public int getI() {
		i++;
		return i;
	}
	//===========================================================================================
	
	public int Count()
	{
		return new ProjectsBean().getLst().getRowCount();
	}
	//===========================================================================================

	public List<Integer> getLstChecked() { // list cà�c project trong bà‰ng project default theo id employee
		this.LstChecked = new ArrayList<Integer>();
		Employees emp = SessionUtil.getUser();
		int id = emp.getEmployeeId();
		List<ProjectDefaults> list= new ProjectDefaultDAO().getList(id);
		for (ProjectDefaults br : list)
		{
			
			if(!this.LstChecked.contains(br.getProjects().getProjectId()))
			{
				this.LstChecked.add(br.getProjects().getProjectId());
			}
		}
		return this.LstChecked;
	}

	public void setLstChecked(List<Integer> lstChecked) {
		LstChecked = lstChecked;
	}
	//===========================================================================================
	public boolean check(int vl) // kiĂª̀‰m tra xem project id Ä‘àƒ cò� trong bà‰ng project default chÆ°a, nĂª̀�u co rĂ´̀€i thì€ trong trang projectdefault.xhmtl sèƒ hiĂª̀‰n thì£ dĂ¢̀�u tì�ch
	{
			boolean ck = false;
			if(this.LstChecked== null)
			{
				List<Integer> lst = new ProjectsBean().getLstChecked();
				if(lst.contains(vl))
				{
					ck = true;
				}
			}
			else
			{
				
				if(this.LstChecked.contains(vl))
				{
					ck = true;
				}
			}
			return ck;
	}
	//===========================================================================================

	public List<Projects> getLstActive() {
		this.LstActive = new ArrayList<Projects>();
		this.LstActive = new ProjectsDAO().getListActive();
		return LstActive;
	}

	public void setLstActive(List<Projects> lstActive) {
		LstActive = lstActive;
	}
	//===========================================================================================

	public Projects getPro(int id) {
		this.pro = new ProjectsDAO().search(id);
				
		return this.pro;
	}

	public void setPro(Projects pro) {
		this.pro = pro;
	}
	//===========================================================================================
	public String delete(int id)
	{
		try
		{
			Projects pr = new ProjectsDAO().search(id);
			new ProjectsDAO().delete(pr);
			return "project/project.xhtml";
		}
		catch (Exception e)
		{
			return "project/project.xhtml";
		}
	}
	//===========================================================================================
	public String update(int id, String code, String name,String description,int status)
	{
		try
		{
			MasterDatas mtd = new MasterDatas(status); // khoi tao masterdata voi tham so truyen la master_data_id
			this.pro = new ProjectsDAO().search(id);
			this.pro.setProjectCode(code);
			this.pro.setProjectName(name);
			this.pro.setDescription(description);
			this.pro.setMasterDatas(mtd);
			new ProjectsDAO().update(this.pro);
			return "project/project.xhtml";
		}
		catch (Exception e)
		{
			return "project/project.xhtml";
		}
	}
	//===========================================================================================
	public String insert (String code, String name,String description,int status)
	{
		try
		{
			MasterDatas mtd = new MasterDatas(status); // khoi tao masterdata voi tham so truyen la master_data_id
			Projects pr = new Projects(code, name, description, mtd);
			new ProjectsDAO().insert(pr);
			return "project/project.xhtml";
		}
		catch (Exception e){
			return "project/project.xhtml";
		}
	}
	//==========================================================================================

	public MasterDatas getMt() {
		return this.mt;
	}

	public void setMt(MasterDatas mt) {
		this.mt = mt;
	}
	//==========================================================================================

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	//==========================================================================================

	
	public String saveListProjectDefault(String txt)
	{
		String link = "project/project_default.xhtml";
		this.arr = txt.split(",");
		Employees emp = SessionUtil.getUser();
		try
		{
			for(int i =0;i<arr.length;i++)
			{
				Projects pr = new ProjectsDAO().search(Integer.parseInt(arr[i]));
				ProjectDefaults prd = new ProjectDefaults(emp,pr);
				new ProjectDefaultDAO().insert(prd);
			}
			
		}
		catch(Exception e)
		{
			return link;
		}
		return link;
	}
	public String link()
	{
		return null;
	}
	public static void main(String[] args) {
		
	}
}
