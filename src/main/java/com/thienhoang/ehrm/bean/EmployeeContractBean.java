package com.thienhoang.ehrm.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.thienhoang.ehrm.dao.MasterDatasDAO;
import com.thienhoang.ehrm.model.EmployeeContracts;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.model.MasterDatas;
import com.thienhoang.ehrm.model.Units;
import com.thienhoang.ehrm.service.interfaces.EmployeeContractService;
import com.thienhoang.ehrm.service.interfaces.UnitService;
import com.thienhoang.ehrm.utils.SessionUtil;

@ManagedBean(name="employeeContractBean")
@ApplicationScoped
public class EmployeeContractBean {

	@ManagedProperty(value="#{eContractService}")
	private EmployeeContractService contractService;
	
	@ManagedProperty(value="#{unitService}")
	private UnitService unitService;
	
	private ListDataModel<EmployeeContracts> list = null;
	private Employees employees;
	private EmployeeContracts contract;
	private Integer editContractId;
	private String company;
	private String contracTypeId;
	private String workingTypeId;
	private BigDecimal fixedValue;
	private Date startDate;
	private Date endDate;
	private String contactNumber;
	private Date sigingDate;
	private String constractContent;
	
	public EmployeeContractService getContractService() {
		return contractService;
	}

	public void setContractService(EmployeeContractService contractService) {
		this.contractService = contractService;
	}
	
	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}

	
	public Integer getEditContractId() {
		return editContractId;
	}

	public void setEditContractId(Integer editContractId) {
		this.editContractId = editContractId;
	}

	public ListDataModel<EmployeeContracts> getList() {
		HttpSession session = SessionUtil.getSession();
		employees = (Employees) session.getAttribute("employee");
		List<EmployeeContracts> lst = contractService.getAllContracts(employees.getEmployeeId());
		list= new ListDataModel<EmployeeContracts>(lst); 
		return list;
	}

	public void setList(ListDataModel<EmployeeContracts> list) {
		this.list = list;
	}
	
	
	
	public EmployeeContracts getContract() {
		return contract;
	}

	public void setContract(EmployeeContracts contract) {
		this.contract = contract;
	}



	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContracTypeId() {
		return contracTypeId;
	}

	public void setContracTypeId(String contracTypeId) {
		this.contracTypeId = contracTypeId;
	}

	public String getWorkingTypeId() {
		return workingTypeId;
	}

	public void setWorkingTypeId(String workingTypeId) {
		this.workingTypeId = workingTypeId;
	}

	public String getConstractContent() {
		return constractContent;
	}

	public void setConstractContent(String constractContent) {
		this.constractContent = constractContent;
	}

	public BigDecimal getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(BigDecimal fixedValue) {
		this.fixedValue = fixedValue;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSigingDate() {
		return sigingDate;
	}

	public void setSigingDate(Date sigingDate) {
		this.sigingDate = sigingDate;
	}

	public Employees getEmployees() {
		HttpSession session = SessionUtil.getSession();
		employees = (Employees)session.getAttribute("employee");
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public void addContract() {
		try {
		HttpSession session = SessionUtil.getSession();
		Employees e = (Employees) session.getAttribute("employee");
		int workingtypeid = Integer.parseInt(workingTypeId);
		int contractypeid = Integer.parseInt(contracTypeId);
		int companyid = Integer.parseInt(company);
		MasterDatas workMas= new MasterDatasDAO().findById(workingtypeid);
		MasterDatas conMas = new MasterDatasDAO().findById(contractypeid);
		Units u = unitService.finById(companyid);
		EmployeeContracts con = new EmployeeContracts(e,workMas,conMas,u,contactNumber,startDate,endDate,sigingDate,null,fixedValue);
		contractService.addNewItem(con);
		}catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteContract(Integer ID) {
		try {
			EmployeeContracts e = contractService.findById(ID);
			contractService.deleteItem(e);
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	public void updateContract() {
		try {
			EmployeeContracts contract = contractService.findById(editContractId);
			int workingtypeid = Integer.parseInt(workingTypeId);
			int contractypeid = Integer.parseInt(contracTypeId);
			int companyid = Integer.parseInt(company);
			MasterDatas workMas= new MasterDatasDAO().findById(workingtypeid);
			MasterDatas conMas = new MasterDatasDAO().findById(contractypeid);
			Units u = unitService.finById(companyid);
			contract.setEmployees(getEmployees());
			contract.setUnits(u);
			contract.setMasterDatasByContractTypeId(conMas);
			contract.setMasterDatasByWorkingTypeId(workMas);
			contract.setWorkingTypeFixedValue(fixedValue);
			contract.setStartDate(startDate);
			contract.setEndDate(endDate);
			contract.setContractNumber(contactNumber);
			contract.setSignDate(sigingDate);
			contractService.editItem(contract);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
