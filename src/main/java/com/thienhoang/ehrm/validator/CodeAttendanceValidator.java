package com.thienhoang.ehrm.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("attendanceCodeValidator")
public class CodeAttendanceValidator implements Validator {

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
	}

}
