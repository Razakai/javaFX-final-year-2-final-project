//Author Sean Adam Holland R00162740
package model;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//Author Sean Adam Holland R00162740
public class ConnectToMySQL {

	public static Connection createConnection() {
		try {
			Connection con = null;


			// Load the MySQL JDBC driver

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);


			// Create a connection to the database

			String serverName = "localhost";

			String schema = "test";

			String url = "jdbc:mysql://localhost:3306/schoolDatabase"; // database name and port number to XAMPP

			String username = "root";

			String password = "";

			con = DriverManager.getConnection(url, username, password); // creates connection


			System.out.println("Successfully Connected to the database!");



			return con;

		} catch (ClassNotFoundException e) { // error messaging

			System.out.println("Could not find the database driver " + e.getMessage());
			return null;
		} catch (SQLException e) {

			System.out.println("Could not connect to the database " + e.getMessage());
			return null;
		}
	}

}

