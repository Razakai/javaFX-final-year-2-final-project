import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Author Sean Adam Holland R00162740
public class DeleteRecord {
    
    /** Creates a new instance of DeleteRecord */
    public DeleteRecord() {
    }
    
     public  void delete(Connection con) {
        try {
            //delete
            Statement deleteStmt = con.createStatement();
            String deleteSQL = " Delete from  customers where CustNo ='C0003'"; // sql code to delete form database
            int res = deleteStmt.executeUpdate(deleteSQL); // executes the query
            System.out.println("The Number or records deleted is      " +res); // res is the number of records deleted/result
            //con.commit();   
            deleteStmt.close(); // closes connection
       }catch (Exception io) {
                System.out.println("error"+io); // catches error messages
       };   
  
     }
    
}