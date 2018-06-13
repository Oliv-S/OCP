package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLDatabaseConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		final String user = "User";
		final String pass = "UserPass";
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement statment = conn.createStatement();
			String sql = "SELECT name FROM animal";
			ResultSet resultSet = statment.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error" + e.getMessage());
		}
	}
}
