//Author Sean Adam Holland R00162740
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import model.Classes;
import model.Student;
import model.Teacher;

public class databaseQueries {
	
	public static String insertStudent(Connection con, Student student) {
        try {
        	int key = databaseQueries.getPrimaryKey(con, "Student");
          
            String query = " Insert into student values (?, ?, ?, ?, ?, ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setInt(1,key + 1);
            pstmt.setString(2,student.getName()); // inserts user input into sql query
            pstmt.setString(3,student.getLastName());
            pstmt.setString(4,student.getDOB());
            pstmt.setInt(5,student.getNumber());
            pstmt.setString(6,student.getEmail());
            pstmt.execute(); // executes query
          
           
            pstmt.close(); // closes the database connection
            return "Student added";
       }catch (Exception io) { // catches error messages
                return"error"+io;
       }
	 
  
     }
	
	public static String addStudentModule(Connection con, int studentNo, int moduleNo) {
        try {
        	int key = databaseQueries.getPrimaryKey(con, "grade");
           
            String query = " Insert into grade values (?, ?, ?, ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setInt(1,key + 1);
            pstmt.setInt(2,moduleNo); // inserts user input into sql query
            pstmt.setInt(3,studentNo);
            pstmt.setInt(4,0);
            
            pstmt.execute(); // executes query
          
            pstmt.close(); // closes the database connection
            return "student module added";
       }catch (Exception io) { // catches error messages
                return"error"+io;
       }  
  
     }
	
	public static String insertModule(Connection con, model.Module module) {
        try {
           
            String query = " Insert into modules values (?, ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setInt(1, databaseQueries.getPrimaryKey(con, "modules") + 1);
            pstmt.setString(2, module.getName());
            pstmt.execute(); // executes query
           
           
            return "Module added";
       }catch (Exception io) { // catches error messages
                return"error"+io;
       }
  
  
     }
	
	
	/*public static  String insertClass(Connection con, Classes classObject) {
        try {
            // insert
        	int key = databaseQueries.getPrimaryKey(con, "class");
           
            String query = " Insert into class values (?, ?, ?, ?, ?, ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
           
            pstmt.execute(); // executes query
          
           
            return "Class added";
       }catch (Exception io) { // catches error messages
                return"error"+io;
       }  
  
     }*/
	
	
	public static  String insertTeacher(Connection con, Teacher teacher) {
        try {
           
           
            String query = " Insert into teacher values (?, ?, ?, ?, ?, ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setInt(1,databaseQueries.getPrimaryKey(con, "teacher") + 1);
            pstmt.setString(2,teacher.getName()); // inserts user input into sql query
            pstmt.setString(3,teacher.getLastName());
            pstmt.setString(4,teacher.getEmail());
            pstmt.setInt(5,teacher.getNumber());
            pstmt.setString(6,teacher.getDegree());
            pstmt.execute(); // executes query
           
            pstmt.close(); // closes the database connection
            return "Teacher added";
       }catch (Exception io) { // catches error messages
                return"error"+io;
       }   
  
     }
	
	
	public static String listStudents(Connection con, String name) {
		 try {
	            
			    String res = "";
	           
	            String query = "select student.studentID, student.fName, student.lName, class.className, modules.moduleName, grade.mark from student inner join class on student.studentID=class.studentID inner join grade on student.studentID = grade.studentID inner join modules on grade.modulesID = modules.modulesID where class.className = ? order by student.fName"; // sql code for insert query
	            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
	            pstmt.setString(1, name);
	           
	            ResultSet rs = pstmt.executeQuery(); // executes query
	            
	            while( rs.next()) {  // prints the results of the query
	                
	                 res += Integer.toString(rs.getInt(1));
	                 res += " " + rs.getString(2);
	                 res += " " + rs.getString(3);
	                 res += " " + rs.getString(4);
	                 res += " " + rs.getString(5);
	                 res += " " + rs.getString(6) +"\n";
	            }
	            rs.close();
	            pstmt.close(); // closes the database connection
	            if(res != "")
	            	return res;
	            else
	            	return "Sorry couldnt find anything";
		 }
		 catch (Exception io) { // catches error messages
	                return "error"+io;
	               
	       }
	       
	}
	
	public static String listTeachers(Connection con) {
		 try {
	            // insert
			    String res = "";
	            Statement stmt = con.createStatement();
	            
	        	
	            String query = "select fname, lname, degree from teacher"; // sql code for insert query
	            ResultSet rs = stmt.executeQuery(query);
	            while( rs.next()) {  // prints the results of the query
	                    
	                 System.out.println("");
	                 res += rs.getString(1);
	                 res += " " + rs.getString(2);
	                 res += " " + rs.getString(3) + "\n";
	                
	            }
	            stmt.close(); // closes the database connection
	            if(res != "")
	            	return res;
	            else
	            	return "Sorry couldnt find anything";
		 }
		 catch (Exception io) { // catches error messages
	                return "error"+io;
		 }
	}
	
	public static String removeStudent(Connection con, String fname, String lName) {
		 try {
	            // insert
	            
	        	
	            String query = "delete from student where fName = ? and lName = ?"; // sql code for insert query
	            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
	            pstmt.setString(1,fname);
	            pstmt.setString(2,lName);// inserts user input into sql query
	            
	            int result = pstmt.executeUpdate();

	            
	            pstmt.close(); // closes the database connection
	           if (result > 0)
	        	   return "Student removed";
	           else
	        	   return "Student not found";
		 }
		 catch (Exception io) { // catches error messages
             return"error"+io;
	 }
	}
	
	
	public static String deleteClass(Connection con, String name) {
		try {
            // insert
            Statement stmt = con.createStatement();
       
        	
            String query = "delete from class where className = ?"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setString(1,name); // inserts user input into sql query
            
            int result = pstmt.executeUpdate();
     
            
            stmt.close(); // closes the database connection
            if(result > 0)
            	return "class deleted";
            else
	           	return "Sorry couldnt find anything";
		}
		catch (Exception io) { // catches error messages
			return "error"+io;
		}
	}
	
	
	public static String deleteTeacher(Connection con, String fname, String lname) {
		try {
            // insert
			PreparedStatement pstmt=con.prepareStatement("delete from teacher where fName=? and lName=?");  
            
            pstmt.setString(1,fname); // inserts user input into sql query
            pstmt.setString(2,lname);
            int result = pstmt.executeUpdate();
 
            pstmt.close(); // closes the database connection
            if(result > 0)
            	return "Teacher removed";
            else
            	return "Teacher not found";
		}
		catch (Exception io) { // catches error messages
			return "error"+io;
		}
	}
	
	public static String deleteStudentModule(Connection con, String name, String moduleName) {
			try {
	            // insert
	        	
	            String query = "delete from grade where studentID =(select studentID from student where fName = ?) and modulesID = (select modulesID from modules where moduleName = ?)"; // sql code for insert query
	            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
	            pstmt.setString(1,name); // inserts user input into sql query
	            pstmt.setString(2,moduleName); 
	            int result = pstmt.executeUpdate();
	           

	            pstmt.close(); // closes the database connection
	            if(result > 0)
	            	return "student's module deleted";
	            else
		           	return "Sorry couldnt find anything";
			}
			catch (Exception io) { // catches error messages
				return "error"+io;
			}
	}
	
	
	public static String deleteModule(Connection con, String name) {
		try {
        
            String query = "delete from modules where moduleName = ?";
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setString(1,name); // inserts user input into sql query
            int result = pstmt.executeUpdate();

            
            pstmt.close(); // closes the database connection
            if(result > 0)
            	return "module deleted";
            else
	           	return "Sorry couldnt find anything";
		}
		catch (Exception io) { // catches error messages
			return "error"+io;
		}
}
	
	public static String editModuleMark(Connection con, String name, String moduleName, int mark) {
		try {
            // insert
        	
            String query = "update grade set mark = ? where studentID =(select studentID from student where fName = ?) and moduleID = (select moduleID from modules where moduleName = ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setString(1,name); // inserts user input into sql query
            pstmt.setString(2,moduleName); 
            pstmt.setInt(3,mark); 
            int result = pstmt.executeUpdate();
           
            pstmt.close(); // closes the database connection
            if(result > 0)
            	return "student's module grade changed";
            else
            	return "Coudnt find the module linked to the student";
           
		}
		catch (Exception io) { // catches error messages
			return "error"+io;
		}
	}
	public static int getPrimaryKey(Connection con, String table) {
		
		try {
			String tablepk = table+"ID";
			PreparedStatement stmt = con.prepareStatement("select max("+tablepk+") from "+table);
			ResultSet rs = stmt.executeQuery();
        	
        	while(rs.next()) {
        		return rs.getInt(1);
        	}
        	stmt.close();
        	rs.close();
            
           
       }
		catch (Exception io) { // catches error messages
                System.out.println("error"+io);
       };
	return 0;   
  
     }//query
	
	
	public static int numberModules(Connection con, int number) {
		try {
            // insert
		    int res = 0;
            
            String query = "select count(moduleID) from grade where studentID = "+number; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
           
            ResultSet rs = pstmt.executeQuery(); // executes query
            
            while( rs.next()) {  // prints the results of the query
                 return rs.getInt(1);
            }
            rs.close();
            pstmt.close(); // closes the database connection
            return res;
	 }
	 catch (Exception io) { // catches error messages
                System.out.println("error"+io);
                return -1;
               
       }
	}
	
	
	
	public static String addStudentToClass(Connection con, int studentNo, String className)
	{
		try {
        	int key = databaseQueries.getPrimaryKey(con, "class");
            
            String query = " Insert into class values (?, ?, ?)"; // sql code for insert query
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setInt(1,key + 1);
            pstmt.setString(2,className);
            pstmt.setInt(3,studentNo);
            int result = pstmt.executeUpdate();            //int res = insertStmt.executeUpdate(insertSQL); // executes the query
           
           
            pstmt.close(); // closes the database connection
            if(result > 0)
            	return "Student added to class";
            else
            	return "Student cannot be found";
       }catch (Exception io) { // catches error messages
                return "error"+io;
       }  
	}
	
}
