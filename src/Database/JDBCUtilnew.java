package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtilnew {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			// Dang ky MySQL Driver voi DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			// Cac thong so
			String url = "jdbc:mySQL://localhost:3306/nguoichoi";
			String username = "root";
			String password = "";
			
			// Tao ket noi
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void prinInfo(Connection c) {
		if(c!=null) {
			try {
				System.out.println(c.getMetaData().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

