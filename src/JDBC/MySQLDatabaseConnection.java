package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class MySQLDatabaseConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		final String user = "User";
		final String pass = "UserPass";
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
			//System.out.println(ToStringBuilder.reflectionToString(conn, ToStringStyle.SHORT_PREFIX_STYLE));
			System.out.println(conn);
			Statement statment = conn.createStatement();
			String sql = "SELECT name FROM animal";
			ResultSet resultSet = statment.executeQuery(sql);

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));				
			}
			
			sql = "SELECT * FROM animal";
			resultSet = statment.executeQuery(sql);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			while (resultSet.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					System.out.print(resultSet.getString(i)+"\t");					
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error" + e.getMessage());
		}
	}
}
