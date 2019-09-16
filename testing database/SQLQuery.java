import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// Author Sean Adam Holland R00162740
public class SQLQuery {
    
    /** Creates a new instance of SQLQuery */
    public SQLQuery() {
    }
    
    public  void queryStatement(Connection con) {
        try {
            Statement stmt = con.createStatement();
            String qry = "select * from branch"; // sql code to be executed
            ResultSet rs = stmt.executeQuery(qry); // code executed
        
            System.out.println("Results of a Statement Object Query");  
            while( rs.next()) {  // prints the results of the query
                System.out.print( rs.getString("branchno"));     
                System.out.print("    " + rs.getString(1));          
                System.out.print("    " + rs.getString(2));        
                System.out.println("");      
            }
        rs.close(); // closes the result set
        stmt.close(); // closes connection to database
       }catch (Exception io) { // catches error messages
                System.out.println("error"+io);
       };   
  
     }//query
    
}