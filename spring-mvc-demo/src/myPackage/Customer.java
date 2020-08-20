package myPackage;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import validation.EmpValidation;

public class Customer {
	
	private String firstName;
	
	@NotNull(message= "is requred (can't be empty)")
	@Size(min=2,max=5, message= "size error (it should be between 1 and 5)")
	private String lastName;
	
	@Min(value= 1, message= "pass value should be greater than 0")
	@Max(value = 10, message = "pass value should be less than 10")
	private int freePasses;   // custom message to handle string input
	
	@Pattern(regexp= "[0-9a-zA-Z]{5}" , message= "only 5 chars/digits")
	private String postalCode;
	
	private String employeeId;
    
	@EmpValidation
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	

}
