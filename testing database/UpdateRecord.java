import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Author Sean Adam Holland R00162740
public class UpdateRecord {
    
    /** Creates a new instance of UpdateRecord */
    public UpdateRecord() {
    }
    
    
     public  void update(Connection con) {
        try {
            //update
            Statement updateStmt = con.createStatement();
            String updateSQL = " Update accounts set AccountBalance = 999 where CustNo ='C0001'"; // sql code
            int res = updateStmt.executeUpdate(updateSQL); // executes query
            System.out.println("The Number or records updated is      " +res); // prints out the number of records updates (int)
           
            updateStmt.close(); // closes connection
       }catch (Exception io) { // catches error messages
                System.out.println("error"+io);
       };   
  
     }//update
    
}
