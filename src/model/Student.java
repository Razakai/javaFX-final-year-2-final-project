//Author Sean Adam Holland R00162740
package model;

import java.util.ArrayList;

public class Student extends Person {
	
	private String dob;
	public Student(String fName, String lName, String email, int number, String dob) {
		super(fName, lName, email, number);
		this.dob = dob;
		
	}
	
	public String getDOB() {
		return this.dob;
	}
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	
}
