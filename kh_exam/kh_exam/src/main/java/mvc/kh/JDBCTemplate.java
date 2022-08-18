package mvc.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemplate {
	static JDBCTemplate jdbcTemplate = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	public static final String user = "scott";
	public static final String pw = "tiger";
	public static JDBCTemplate getInstance() {
		if(jdbcTemplate == null) {
			jdbcTemplate = new JDBCTemplate();
			return jdbcTemplate;
		}else {
			return jdbcTemplate;
		}
	}
	public Connection getConnect() {
		if(con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url,user,pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
