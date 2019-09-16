import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Author: Sean Adam Holland R00162740
public class SQLQueryJoin {
    
    /** Creates a new instance of SQLQuery */
    public SQLQueryJoin() {
    }
    
    public  void queryStatement(Connection con) {
        try {
           
        Statement stmt = con.createStatement();
        String qry = "SELECT customers.Fname, accounts.AccountNo, customers.CustNo, accounts.AccountBalance " + 
        		"FROM accounts " + 
        		"INNER JOIN customers ON accounts.CustNo=Customers.CustNo;"; // sql join query to be executed
        ResultSet rs = stmt.executeQuery(qry); // code executed
    
        System.out.println("Results of a Statement Object Query");  
        while( rs.next()) {    // prints results of the query
            System.out.print("    " + rs.getString(1));          
            System.out.print("    " + rs.getString(2)); 
            System.out.print("    " + rs.getString(3)); 
            System.out.print("    " + rs.getString(4));
            System.out.println("");      
        }
    rs.close(); // closes result set
    stmt.close(); // closes database connection
       }catch (Exception io) { // catches error messages
                System.out.println("error"+io);
       };   
  
     }//query
    
}