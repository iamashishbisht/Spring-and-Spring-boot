package myPackage;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName= "Ashi";
	private String lastName;
	private String dropdown;
	private String drop;
	private String[] dropdown2= {"hi","bye","hi-bye"};
	
	private String myButton;
	private String myCheckbox;
	
	public String getMyCheckbox() {
		return myCheckbox;
	}

	public void setMyCheckbox(String myCheckbox) {
		this.myCheckbox = myCheckbox;
	}

	public String getMyButton() {
		return myButton;
	}

	public void setMyButton(String myButton) {
		this.myButton = myButton;
	}
	private LinkedHashMap<String, String> down = new LinkedHashMap<String, String>();
	
	public Student() {
	down.put("1", "PHP");
	down.put("2", "c");
	down.put("3", "java");
	down.put("4", "Perl");
	}
	
	public LinkedHashMap<String, String> getDown() {
		return down;
	}
	public void setDown(LinkedHashMap<String, String> down) {
		this.down = down;
	}
	public String getDrop() {
		return drop;
	}
	public void setDrop(String drop) {
		this.drop = drop;
	}
	
	public String[] getDropdown2() {
		return dropdown2;
	}
	public void setDropdown2(String[] dropdown2) {
		this.dropdown2 = dropdown2;
	}
	public String getDropdown() {
		return dropdown;
	}
	public void setDropdown(String dropdown) {
		this.dropdown = dropdown;
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
