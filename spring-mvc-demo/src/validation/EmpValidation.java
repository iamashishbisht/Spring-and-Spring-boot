package validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmployeeValidation.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface EmpValidation{
	
	public String value() default "EMP";
	
	public String message() default "Must start with EMP";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};

}