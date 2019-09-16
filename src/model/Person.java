//Author Sean Adam Holland R00162740
package model;

public class Person {
	
	private String fName;
	private String lName;
	private String email;
	private int number;

	public Person(String fName, String lName, String email, int number){
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.number = number;
	}
	
	public String getName() {
		return this.fName;
	}
	
	public String getLastName() {
		return this.lName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setName(String name, String lname) {
		this.fName = name;
		this.lName = lname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
}