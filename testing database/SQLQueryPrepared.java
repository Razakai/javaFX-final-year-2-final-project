import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Author Sean Adam Holland R00162740
public class SQLQueryPrepared {
    
    /** Creates a new instance of SQLQueryPrepared */
    public SQLQueryPrepared() {
    }
    
    public  void queryStatement(Connection con) {
        try {
        	System.out.println("enter branch number:"); // collects user information for the prepared query
        	Scanner BranchNoScan = new Scanner(System.in);
        	Scanner BranchNameScan = new Scanner(System.in); // scanner objects to read data form user
        	String BranchNo = BranchNoScan.nextLine();
        	System.out.println("enter branch name:");
        	String BranchName = BranchNameScan.nextLine();
            String query = "Select * From branch where branchNo = ? and branchName = ?"; // sql query where the ? is where user input will be inserted
            PreparedStatement pstmt = con.prepareStatement(query); // creates connection to database
            pstmt.setString(1,BranchNo); // inserts user input into sql query
            pstmt.setString(2,BranchName);
           
            ResultSet rs = pstmt.executeQuery(); // executes query
        
        
            System.out.println("Results of a PreparedStatement Object");
            while( rs.next()) {  // prints out query result set
                System.out.print(rs.getString("branchNo"));     
                System.out.print("    " + rs.getString(1)); 
                System.out.print("    " + rs.getString(2)); 
                System.out.println("");
                
            }
           rs.close(); // closes result set
           pstmt.close(); // closes database connection
       }catch (Exception io) { // catches error messages
                System.out.println("error"+io);
       };   
  
     }//query
    
}
