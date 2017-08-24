import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan_db", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from person");
			//stmt.executeUpdate("insert into person values (NULL,'dafadfaf','dfaf')");			                
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){
					rs.close();
					rs=null;
				}
				if(stmt!=null){
					stmt.close();
					stmt=null;
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
