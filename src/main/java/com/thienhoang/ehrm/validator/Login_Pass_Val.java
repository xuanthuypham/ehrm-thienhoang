package com.thienhoang.ehrm.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.thienhoang.ehrm.dao.UsersDAO;
import com.thienhoang.ehrm.model.Users;

@FacesValidator("pass_validator")
public class Login_Pass_Val implements Validator{
	
		public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
			
		    
	    	
		    String val = value.toString();
		    if(val.length()==0 || val == null)
		    {
		    	FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Không được để trống");
			    throw new ValidatorException(msg);
		    }
		   
	}
}
