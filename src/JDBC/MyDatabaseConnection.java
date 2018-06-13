package JDBC;
import java.sql.*;

public class MyDatabaseConnection {

	public static void main(String[] args) {
		String url = "jdbc:derby:zoo";
		try {
			Connection conn = DriverManager.getConnection(url);
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
