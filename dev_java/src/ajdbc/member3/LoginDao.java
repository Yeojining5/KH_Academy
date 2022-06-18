package ajdbc.member3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ajdbc.zipcode.DBConnectionMgr;

public class LoginDao {
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	


	/*************************************************************************
	 * 아이디 중복체크 구현하기
	 * @param 사용자가 입력한 아이디
	 * @return boolean
	 * 만일 boolean을 선택했다면 false이면 사용할 수 없다.  t rue이면 사용할 수 있다.
	 * 만일 boolean을 선택했다면 false이면 사용할 수 있다.  true이면 사용할 수 없다.
	SELECT 1
	  FROM dual
	 WHERE EXISTS (SELECT mem_name
	                 FROM member
	                WHERE mem_id ='tomato') 
	 질문 1: tomato가 존재하는데 false가 뜹니다. 뭐가 문제인가요?
	 질문 2: java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1 일때
	        ?자리에 들어갈 값을 치환하지 않은 경우
	 질문 3: 토드에서 사용한 변수를 그대로 사용한 경우 반드시 ?로 바꾸어 쓸 것.
	 질문 4: java.sql.SQLSyntaxErrorException: ORA-00911: 문자가 부적합합니다
	       쿼리문 뒤에 세미콜론을 붙인 경우에 발생하는 오류 입니다.                       
	*************************************************************************/  
	// Member3Ship에 있던거 붙여넣기
	public boolean idCheck(String user_id) {
		boolean isOk = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT 1                               ");
		sql.append("  FROM dual                            ");
		sql.append(" WHERE EXISTS (SELECT mem_name         ");
		sql.append("                 FROM member           ");
		sql.append("                WHERE mem_id =?)"); 	
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반드시 반납할 것. - 자바 튜닝팀 지적사항
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return isOk;
	}

	
	/*******************************************************************
	 * 로그인 구현
	 * @param mem_id - 사용자가 입력한 아이디 받아오기
	 * @param mem_pw - 사용자가 입력한 비밀번호 받아오기
	 * @return - 사용자 이름 
	 *******************************************************************/
	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		
		 // tomato라는 id를 2개 만들었을때 버그가 발생할 수 있으므로
		 // (중복검사하면 회원가입 버튼 활성화되는 문제)
		 // 인라인뷰를 통해 rownum 이 1인 데이터만 다시 추출
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                                      ");
		sql.append("      mem_name                              ");
		sql.append("FROM(                                       ");
		sql.append("   SELECT                                   ");
		sql.append("	 CASE WHEN mem_id=? THEN                ");
		sql.append("	   CASE WHEN mem_pw=? THEN mem_name     ");
        sql.append("      	 ELSE '0'                           ");
        sql.append("      	 END                                ");
        sql.append("      ELSE '-1'                             ");
        sql.append("      END AS mem_name                       ");
        sql.append("     FROM member                            ");
        sql.append("     ORDER BY mem_name desc                 "); // 정렬구문 꼭 필요!!
        sql.append("    )                                       ");
        sql.append("WHERE ROWNUM = 1                            ");
		try {
			con = dbMgr.getConnection();
	    	pstmt = con.prepareStatement(sql.toString()); // 물음표 채우기
	    	pstmt.setString(1, mem_id);
	    	pstmt.setString(2, mem_pw);
	    	rs = pstmt.executeQuery();
	    	// 조회 결과는 0이거나 1을 출력하는 row이므로 if문 사용
	    	
	    	if(rs.next()) {
	    		mem_name = rs.getString("mem_name");
	    	}
	    	System.out.println("mem_name : "+mem_name);
		} catch (SQLException se) {
	    	System.out.println("[[query]]"+ sql.toString());
	    	System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반납은 생성된 역순으로 한다.
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return mem_name;
	}	
	

}
