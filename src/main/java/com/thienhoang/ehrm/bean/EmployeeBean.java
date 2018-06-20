package com.thienhoang.ehrm.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.omg.CORBA.Request;

import com.thienhoang.ehrm.service.interfaces.EmployeeService;
import com.thienhoang.ehrm.service.interfaces.ReasonService;
import com.thienhoang.ehrm.utils.SessionUtil;
import com.thienhoang.ehrm.dao.MasterDatasDAO;
import com.thienhoang.ehrm.model.Employees;
import com.thienhoang.ehrm.model.MasterDatas;
import com.thienhoang.ehrm.model.Reasons;

@ManagedBean(name="employeeBean")
@ApplicationScoped
public class EmployeeBean {

	@ManagedProperty(value="#{employeeService}")
	private EmployeeService employeeService;
	
	@ManagedProperty(value="#{reasonService}")
	private ReasonService reasonService;
	
	private Employees employee;
	private ListDataModel<Employees> list;
	private ListDataModel<Employees> listAdvance;
	
	//atribute Employee
	private Integer employeeTitle;
	private String firstName;
	private String midleName = "";
	private String lastName;
	private Integer employeeGender;
	private String employee8ID;
	private String attendanceCode;
	private String firstNameNative;
	private String lastNameNative;
	private String permarentAddVN;
	private Date dateOfBirth;
	private String socialBook;
	private Integer nationality;
	private Boolean isForeigner;
	private String foreignerContract;
	private String foreignerCellphone;
	private String foreignerAddress;
	private String idCard;
	private Date idCardIssuedDate;
	private String idCardIssuedPlace;
	private Date passportExpiryDate;
	private String pitCode;
	private Date startDate;
	private Date registedStopWorkingDate;
	private Date actualStopWorkingDate;
	private Boolean isReplace;
	private String permanentAddressENG;
	private String birthLocation;
	private Boolean active;
	private Integer martialStatus;
	private String nativeCountry;
	private String passportNumber;
	private Date passportIssueDate;
	private String passportIssuePlace;
	private String moreInformation;
	private Date endOfProbation;
	private String reason;
	private Boolean isInUnion;
	// atribute Search
	private String keyword=null;
	private Integer companySearch = 0;
	private String nameSearch = null;
	private Integer statusSearch = 2;
	private Integer genderSearch = 0;
	
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public ReasonService getReasonService() {
		return reasonService;
	}

	public void setReasonService(ReasonService reasonService) {
		this.reasonService = reasonService;
	}

	public Integer getCompanySearch() {
		return companySearch;
	}

	public Integer getEmployeeTitle() {
		return employeeTitle;
	}

	public void setEmployeeTitle(Integer employeeTitle) {
		this.employeeTitle = employeeTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(Integer employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployee8ID() {
	//	this.employee8ID = employeeService.generateEmployee8Id();
		return employee8ID;
	}

	public void setEmployee8ID(String employee8id) {
		employee8ID = employee8id;
	}

	public String getAttendanceCode() {
	//	this.attendanceCode = employeeService.generateAttendanceCode();
		return attendanceCode;
	}

	public void setAttendanceCode(String attendanceCode) {
		this.attendanceCode = attendanceCode;
	}

	public String getFirstNameNative() {
		return firstNameNative;
	}

	public void setFirstNameNative(String firstNameNative) {
		this.firstNameNative = firstNameNative;
	}

	public String getLastNameNative() {
		return lastNameNative;
	}

	public void setLastNameNative(String lastNameNative) {
		this.lastNameNative = lastNameNative;
	}

	public String getPermarentAddVN() {
		return permarentAddVN;
	}

	public void setPermarentAddVN(String permarentAddVN) {
		this.permarentAddVN = permarentAddVN;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSocialBook() {
		return socialBook;
	}
	
	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public void setSocialBook(String socialBook) {
		this.socialBook = socialBook;
	}

	public Integer getNationality() {
		return nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	public Boolean getIsForeigner() {
		return isForeigner;
	}

	public void setIsForeigner(Boolean isForeigner) {
		this.isForeigner = isForeigner;
	}

	public String getForeignerContract() {
		return foreignerContract;
	}

	public void setForeignerContract(String foreignerContract) {
		this.foreignerContract = foreignerContract;
	}

	public String getForeignerCellphone() {
		return foreignerCellphone;
	}

	public void setForeignerCellphone(String foreignerCellphone) {
		this.foreignerCellphone = foreignerCellphone;
	}

	public String getForeignerAddress() {
		return foreignerAddress;
	}

	public void setForeignerAddress(String foreignerAddress) {
		this.foreignerAddress = foreignerAddress;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getIdCardIssuedDate() {
		return idCardIssuedDate;
	}

	public void setIdCardIssuedDate(Date idCardIssuedDate) {
		this.idCardIssuedDate = idCardIssuedDate;
	}

	public String getIdCardIssuedPlace() {
		return idCardIssuedPlace;
	}

	public void setIdCardIssuedPlace(String idCardIssuedPlace) {
		this.idCardIssuedPlace = idCardIssuedPlace;
	}

	public Date getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public String getPitCode() {
		return pitCode;
	}

	public void setPitCode(String pitCode) {
		this.pitCode = pitCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getRegistedStopWorkingDate() {
		return registedStopWorkingDate;
	}

	public void setRegistedStopWorkingDate(Date registedStopWorkingDate) {
		this.registedStopWorkingDate = registedStopWorkingDate;
	}

	public Date getActualStopWorkingDate() {
		return actualStopWorkingDate;
	}

	public void setActualStopWorkingDate(Date actualStopWorkingDate) {
		this.actualStopWorkingDate = actualStopWorkingDate;
	}

	public Boolean getIsReplace() {
		return isReplace;
	}

	public void setIsReplace(Boolean isReplace) {
		this.isReplace = isReplace;
	}

	public String getPermanentAddressENG() {
		return permanentAddressENG;
	}

	public void setPermanentAddressENG(String permanentAddressENG) {
		this.permanentAddressENG = permanentAddressENG;
	}

	public String getBirthLocation() {
		return birthLocation;
	}

	public void setBirthLocation(String birthLocation) {
		this.birthLocation = birthLocation;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(Integer martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getNativeCountry() {
		return nativeCountry;
	}

	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getPassportIssueDate() {
		return passportIssueDate;
	}

	public void setPassportIssueDate(Date passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}

	public String getPassportIssuePlace() {
		return passportIssuePlace;
	}

	public void setPassportIssuePlace(String passportIssuePlace) {
		this.passportIssuePlace = passportIssuePlace;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public Date getEndOfProbation() {
		return endOfProbation;
	}

	public void setEndOfProbation(Date endOfProbation) {
		this.endOfProbation = endOfProbation;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getIsInUnion() {
		return isInUnion;
	}

	public void setIsInUnion(Boolean isInUnion) {
		this.isInUnion = isInUnion;
	}

	public void setCompanySearch(Integer companySearch) {
		this.companySearch = companySearch;
	}
	
	public ListDataModel<Employees> getListAdvance() {
		List<Employees> lst = employeeService.getAllEmployeeAdvance(companySearch, nameSearch, statusSearch, genderSearch);
		listAdvance = new ListDataModel<Employees>(lst);
		return listAdvance;
	}

	public void setListAdvance(ListDataModel<Employees> listAdvance) {
		this.listAdvance = listAdvance;
	}

	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public Integer getStatusSearch() {
		return statusSearch;
	}

	public void setStatusSearch(Integer statusSearch) {
		this.statusSearch = statusSearch;
	}

	public Integer getGenderSearch() {
		return genderSearch;
	}

	public void setGenderSearch(Integer genderSearch) {
		this.genderSearch = genderSearch;
	}

	public ListDataModel<Employees> getList() {
		List<Employees> lst = employeeService.getAllEmployees(keyword);
		list = new ListDataModel<Employees>(lst);
		return list;
	}

	public void setList(ListDataModel<Employees> list) {
		this.list = list;
	}	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Employees getEmployee() {
		HttpSession session = SessionUtil.getSession();
		employee = (Employees)session.getAttribute("employee");
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public String navigateEmployeeDetail(Employees e) {
		HttpSession session = SessionUtil.getSession();
		session.setAttribute("employee", e);
		return "list_employee_information.xhtml";
	}
	public String search() {
		return null;
	}
	
	public List<Reasons> getListReasons(){
		List<Reasons> list = null;
		list = (List<Reasons>) reasonService.getList();
		return list;
	}
	
	public String addEmployee() {
		boolean success = false;
		MasterDatasDAO dao = new MasterDatasDAO();
		MasterDatas gender = dao.findById(employeeGender);
		MasterDatas title = dao.findById(employeeTitle);
		MasterDatas nanlity = dao.findById(nationality);
		MasterDatas martial = dao.findById(martialStatus);
		Employees e = new Employees(title,firstName,midleName,lastName,gender,getEmployee8ID(),getAttendanceCode(),firstNameNative,lastNameNative,permarentAddVN,
				dateOfBirth,socialBook,nanlity,isForeigner,foreignerContract,foreignerCellphone,foreignerAddress,idCard,idCardIssuedDate,idCardIssuedPlace,
				passportExpiryDate,pitCode,startDate,registedStopWorkingDate,actualStopWorkingDate,isReplace,permanentAddressENG,birthLocation,active,martial,nativeCountry,passportNumber,
				passportIssueDate,passportIssuePlace,moreInformation,endOfProbation,reason,isInUnion);
		try {
		employeeService.addEmployee(e);
		success = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (success == true) {
			FacesMessage message = new FacesMessage("Thành công !!!");
			FacesContext.getCurrentInstance().addMessage(":form_add_employee", message);
		} else {
			FacesMessage message = new FacesMessage("Không thành công !!!");
			FacesContext.getCurrentInstance().addMessage(":form_add_employee", message);			
		}
		return "employee_add";
	}
	public String updateEmployeeNavigate() {
		HttpSession session = SessionUtil.getSession();
		employee = (Employees)session.getAttribute("employee");
		return "employee_edit";
	}
	
	public String updateEmployee() {
		employeeService.editEmployee(employee);
		return "employee_edit";
	}
	public void deleteEmployee(Integer ID) {
		try {
		Employees e = employeeService.findById(ID);
		employeeService.deleteEmployee(e);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
