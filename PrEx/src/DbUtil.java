

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtil {

	public static void main(String[] args) {
		try {
			getCon();
			System.out.println("접속 클리어 ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static Connection getCon() throws Exception {
		
		
		final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		final String USERNAME = "scott";
		final String PASSWORD = "tiger";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("연음");
		
		return con;
	}
	
	public static void close(Connection con , PreparedStatement ps) {
		close(con,ps,null);
	}
	
	public static void close(Connection con , PreparedStatement ps , ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
