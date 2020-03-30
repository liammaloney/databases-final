/**
 * @author Vidulash Rajaratnam 8190398
 * @author Liam Maloney 8129429
 * @author Zhen Wang 300057304
 * 
 * 
 * This file was composed from a base of the lab 7 connection example written by Sai Rahul
 */
package code;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//Import the JDBC driver
import java.sql.*;
import java.util.Properties;

public class connection {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		Properties prop = new Properties();

		try {
			FileReader reader = new FileReader("application.properties");
			prop.load(reader);
			
			// Load the driver
			Class.forName(prop.getProperty("db.driver"));

			// Connect to the database
			Connection conn = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"), prop.getProperty("db.password"));
			// Issue a Query and process the result
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("db.query"));
			while (rs.next()) {
				System.out.println(rs.getString(1) + ", "+rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException Raised");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException Raised");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException Raised");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException araised");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
		}
	}

}
