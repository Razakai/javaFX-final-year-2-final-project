//Author Sean Adam Holland R00162740
package model;

public class Teacher extends Person {
	private String degree;
	
	public Teacher(String name, String Lname, String email, int number, String degree){
		super(name, Lname, email, number);
		this.degree = degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getDegree() {
		return this.degree;
	}
	
	
}
