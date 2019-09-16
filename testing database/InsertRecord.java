import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Author Sean Adam Holland R00162740
public class InsertRecord {
    
    /** Creates a new instance of InsertRecord */
    public InsertRecord() {
    }
    
     public  void insert(Connection con) {
        try {
            // insert
            Statement insertStmt = con.createStatement();
            String insertSQL = " Insert into customers values ('C0003', 'Donald', 'Trump', 'White House', 1232222222, 'B0001')"; // sql code for insert query
            int res = insertStmt.executeUpdate(insertSQL); // executes the query
            System.out.println("The Number or records inserted is      " +res); // res is the result of the query
            
            insertStmt.close(); // closes the database connection
       }catch (Exception io) { // catches error messages
                System.out.println("error"+io);
       };   
  
     }
}