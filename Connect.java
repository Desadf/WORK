import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Connect {
	void go() throws SQLException {
		GUI num = new GUI();
		int a = num.geta();
		int b = num.getb();

		String host = "localhost";
		int port = 1522;
		String sid = "zero";
		String user = "C##Z";
		String pwd = "1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC Driver is not found");
			e.printStackTrace();
		}
		String url = String.format("jdbc:oracle:thin:@%s:%d:%s", host, port, sid);
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, user, pwd);

		} catch (SQLException e) {
			System.out.println("Connection Failed : " + e.getMessage());
		}
		if (c != null) {
			System.out.println("Control your database!");
		} else {
			System.out.println("Failed to make connection!");
		}

		// connect
		Statement stmt = c.createStatement();
		String sql = "update mdata set inn = ?";
		PreparedStatement preparedStmt = c.prepareStatement(sql);
		preparedStmt.setInt(1, a);
		preparedStmt.executeUpdate();

		ResultSet rs = stmt.executeQuery("SELECT * FROM MDATA");
		while (rs.next()) {
			int res1 = rs.getInt(1);
			int res2 = rs.getInt(2);
			int res3 = rs.getInt(3);
			res3 = res1 - res2;
			System.out.println("You Have " + res3 + "$");
		}

			c.close();
	
	}
}
