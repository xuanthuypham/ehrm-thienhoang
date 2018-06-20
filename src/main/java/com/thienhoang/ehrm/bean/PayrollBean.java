package com.thienhoang.ehrm.bean;
import javax.servlet.http.HttpSession;

import com.thienhoang.ehrm.dao.EmployeeIncomesDAO;
import com.thienhoang.ehrm.dao.FinancialYearsDAO;
import com.thienhoang.ehrm.dao.MasterDatasDAO;
import com.thienhoang.ehrm.dao.PeriodDAO;
import com.thienhoang.ehrm.dao.ProjectsDAO;

import com.thienhoang.ehrm.utils.SessionUtil;
import com.thienhoang.ehrm.model.EmployeeAccounts;
import com.thienhoang.ehrm.model.EmployeeEmails;
import com.thienhoang.ehrm.model.EmployeeIncomes;
import com.thienhoang.ehrm.model.EmployeePhones;
import com.thienhoang.ehrm.model.EmployeeUnits;
import com.thienhoang.ehrm.model.Units;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.model.FinancialYears;
import com.thienhoang.ehrm.model.MasterDatas;
import com.thienhoang.ehrm.model.Periods;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
@ManagedBean(name="payroll_bean",eager = true)
@SessionScoped
public class PayrollBean {
	private int id;
	private HttpSession session = SessionUtil.getSession();
	private Employees emp;
	private DataModel<Employees> lst;
	 
	 
	//=========================================================
	 
	 public DataModel<Employees> getListEmp()
	 {
		 List<Employees> listt = new ProjectsDAO().listEmp();
		 lst= new ListDataModel<Employees>(listt); 
		 return lst;
	 }
		

	//============================================================================
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//============================================================================
	public Employees getEmp() {
		//this.emp = new ProjectsDAO().getEmployeeById(this.id);
		return this.emp;
	}
	public void setEmp(Employees emp) {
		this.emp = emp;
	}
	
	//============================================================================
	public String payrolldetail()
	{
		//this.id = id;
//		this.emp= null;
//		this.emp = new Employees();
//		this.emp = new ProjectsDAO().getEmployeeById(this.id);
		//HttpSession session = SessionUtil.getSession();
		//session.setAttribute("payrolldetail", this.empx);
		
		HttpSession session = SessionUtil.getSession();
		session.setAttribute("emp_sess", (Employees) lst.getRowData());
		this.emp = (Employees)session.getAttribute("emp_sess");
		return "payroll.xhtml";
	}
	//============================================================================
	
	
	public String getFullName()
	{
		String full_name = this.emp.getLastName() +" "+this.emp.getMiddleName() +" "+this.emp.getFirstName();
		return full_name; 
	}
	//============================================================================
	public String getBankAccount()
	{
		String str = "";
		Set<EmployeeAccounts> lst = this.emp.getEmployeeAccountses();
		for(EmployeeAccounts ea :lst)
		{
			str+= ea.getAccountNumber() + "\n";
		}
		return str;
	}
	//============================================================================
	public String getEmail()
	{
		String str="";
		Set<EmployeeEmails> lst = this.emp.getEmployeeEmailses();
		for(EmployeeEmails ee : lst)
		{
			str+=ee.getEmailAddress() + "\n";
		}
		return str;
	}
	//============================================================================
	public String getPhone()
	{
		String str="";
		Set<EmployeePhones> lst = this.emp.getEmployeePhoneses();
		for(EmployeePhones ep : lst)
		{
			str+=ep.getPhoneNumber() + "\n";
		}
		return null;
	}
	//============================================================================
	public String getCurrentUnit()
	{
		String str="";
		Set<EmployeeUnits> lst = this.emp.getEmployeeUnitses();
		int size = lst.size();
		int dem = 0;
		for(EmployeeUnits ep : lst)
		{
			if(dem==size-1)
			{
				Units uni = ep.getUnits();
				str+=uni.getUnitName();
			}
			dem++;
		}
		return getMainString(str);
	}
	
	//============================================================================
	public static String getMainString(String xxx)
	{
		//<MultiLanguage><Data lang="vi-VN"/><Data lang="en-US"/></MultiLanguage>
		xxx.replace("<MultiLanguage><Data lang=\"vi-VN\"/><Data lang=\"en-US\"/></MultiLanguage>", "");
		xxx.replace("", "");
		xxx.replace("<MultiLanguage><Data lang=\"en-US\">", "");
		xxx.replace("</Data></MultiLanguage>", "");
		return xxx;
	}
	//============================================================================
	public String getBirthLocation()
	{
		return this.emp.getBirthLocation();
	}
	//============================================================================
	public String getSeniority(/*String date*/)
	{
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 long diff = -1;
		 int diffY =0;
		 int diffM=0;
		 int diffD=0;
		  try {
			String date = this.emp.getWorkingStartDate().toString();
		    Date dateStart = format.parse(date);
		    String now = format.format(new Date()); 
		    Date dateEnd = format.parse(now);

		    
		    diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000);
		    diffY = (int)diff / 365; 
		    diffM = (int)(diff - diffY*365)/30;
		    diffD = (int)diff- diffY*365-diffM*30;
		  } catch (Exception e) {
		    return "#NaN";
		  }
		  return diffY+"y "+diffM+"m "+diffD+"d";
	}
	//============================================================================
	public List<MasterDatas> getListCrr(int TYPE_ID)
	{
		List<MasterDatas> lst = new MasterDatasDAO().getList(TYPE_ID);
		return lst;
	}
	//============================================================================
	public List<FinancialYears> getListYear()
	{
		List<FinancialYears> lst = new FinancialYearsDAO().getList();
		return lst;
	}
	//============================================================================
	public List<Periods> getListPeriod(String year)
	{
		List<Periods> lst = new PeriodDAO().getList(year);
		return lst;
	}
	//============================================================================
	public String returnLink()
	{
		return "payroll/employees-list.xhtml";
	}
	//============================================================================
	public List<EmployeeIncomes> getList()
	{
		List<EmployeeIncomes> lst = null;
		if(finalcial_year==null || period== null)
		{
			return lst;
		}
		else
		{
			int IncomeID = new  PeriodDAO().search(finalcial_year, period);
			int EmpID = this.emp.getEmployeeId();
			lst = new EmployeeIncomesDAO().getList(IncomeID,EmpID);
		}
		
		return lst;
	}
	//============================================================================

	private int currency;
	private String finalcial_year;
	private String period;
	
	public int getCurrency() {
		return currency;
	}


	public void setCurrency(int currency) {
		this.currency = currency;
	}


	public String getFinalcial_year() {
		return finalcial_year;
	}


	public void setFinalcial_year(String finalcial_year) {
		this.finalcial_year = finalcial_year;
	}


	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
	}


	//============================================================================
	public static void main(String[] args) {
		List<MasterDatas> lst = new PayrollBean().getListCrr(9);
		for(MasterDatas mt :lst )
		{
			System.out.println(mt.getMasterDataCode());
		}
	}
	
}
