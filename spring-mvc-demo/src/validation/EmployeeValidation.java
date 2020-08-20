package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeValidation implements ConstraintValidator<EmpValidation, String> {

	public String theEmpIdPrefix;
	
	@Override
	public void initialize(EmpValidation theEmpValidation) {
		// TODO Auto-generated method stub
		theEmpIdPrefix = theEmpValidation.value();
		
	}

	@Override
	public boolean isValid(String theFormData, ConstraintValidatorContext theConstraintValidatorContext) {
		// TODO Auto-generated method stub
		boolean result;
		if (theFormData != null) {
			result = theFormData.startsWith(theEmpIdPrefix);
			return result;
		}
		else
			result = true;
		
		return false;
	}

}
