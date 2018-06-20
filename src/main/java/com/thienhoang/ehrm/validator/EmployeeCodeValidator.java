package com.thienhoang.ehrm.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thienhoang.ehrm.service.interfaces.EmployeeService;

@Component
@RequestScoped
public class EmployeeCodeValidator implements Validator {

	@Autowired
	private EmployeeService employeeService;
	
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object obj) throws ValidatorException {
		// TODO Auto-generated method stub
		String val = obj.toString();
		String pattern = "^[0-9]{8}$$";
		Pattern p = Pattern.compile(pattern);
		Boolean m = p.matcher(val).matches();
		if (m == false) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Dữ liệu phải là một chuỗi số gồm 8 ký tự !!!");
			throw new ValidatorException(message);
		}
		if (employeeService.find8ID(val) == true) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Mã nhân viên đã tồn tại !!!");
			throw new ValidatorException(message);
		}
	}

}
