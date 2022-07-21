package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@192.168.0.4:1521:orcl11";
	public static final String user = "scott";
	public static final String pw = "tiger";
	
	// 물리적으로 떨어있는 오라클 서버와 커넥션을 맺는데 꼭 필요한 코드(제조사 정보 필수)
	// 
	public Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	// freeConnection 사용한 자원을 반납 - 오버로딩
	// ResultSet : 오라클의 커서 조작(select문) / PreparedStatement : 개발자가 작성한 SQL문 전달, 그에대한 요청
	// Connection : 물리적으로 떨어져 있는 서버와의 채널을 만드는데 필요
	public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con){
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// freeConnection 사용한 자원을 반납 - 오버로딩
	// 커서에 대한 파라미터는 빠져있음 - insert, update, delete 의 경우 반환값이 커서가 아닌 int이기 때문(1건이 삭제...)
	public static void freeConnection(PreparedStatement pstmt, Connection con){ 
		try {
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
