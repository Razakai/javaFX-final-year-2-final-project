//Author Sean Adam Holland R00162740
package controller;

import java.sql.Connection;

public class schoolController {
	
	
	public static boolean validateStudent(String fname, String lName, String email,String number, String DOB) {
		boolean res = true;
		try {
		
		String [] validate = {fname, lName, email, number, DOB};
		for(int i = 0; i < validate.length; i++) {
			if(i == 3)
				if(Integer.parseInt(validate[i]) < 1) { // checks if the string can be converted to a number
					res = false;
				}
			
			else if(validate[i].equals(""))
				res = false;
			}
		}
		catch(NumberFormatException e){ // catches number errors
			res = false;
		}
		
		
		
		return res;
	}
	
	public static boolean validateTeacher(String name, String lName, String email, String number, String degree) {
		boolean res = true;
		try {
		String [] validate = { name, lName, email, number, degree};
		for(int i = 0;  i < validate.length; i++) {
			if(i == 3) 
				if(Integer.parseInt(validate[i]) < 1) {
					res = false;
				}
			
			
			
			if(validate[i].equals(""))  // checks if string is empty
				res = false;
		}
		}
		catch(NumberFormatException e){
			res = false;
		}
		
		return res;
	}
	
	
	public static boolean validateModuleAndClass(String name) {
		boolean res = true;
		if(name.equals(""))
			res = false;
		
		return res;
	}
	
	public static boolean validateNumber(String number) {
		boolean res = true;
		try {
			if(Integer.parseInt(number) < 1)
				res = false;
		}
		catch(NumberFormatException e){ // catches number errors
			res = false;
		}
		return res;
	}
	
	public static boolean validateText(String text) {
		boolean res = true;
		
		if(text.equals("")) // checks if string is empty
			res = false;
		
		return res;
	}
	
	public static Connection createConnection() {
		return model.ConnectToMySQL.createConnection();
	}
	
	
}
