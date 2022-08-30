package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;


public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";//ojdbc6.jar  의존관계, 의존성 주입 제조사
	//서버측의 아이피, 서버측의 포트번호, 서버측의 오라클 SID가 필요하다.
	public static final String _URL    = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	public static final String _USER   = "hr";
	public static final String _PW     = "tiger";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public TestDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}	
	public List<Test> selectList() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, title, writer, content FROM khboard");
		List<Test> testList = new ArrayList<>();
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Test test = null;
			while(rs.next()) {
				test = new Test();
				test.setSeq(rs.getInt("seq"));
				test.setWriter(rs.getString("writer"));
				test.setTitle(rs.getString("title"));
				test.setContent(rs.getString("content"));
				test.setRegdate(rs.getString("regdate"));
				testList.add(test);
			}		
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return testList;
	}
	//INSERT INTO test(id,name,age) VALUES('haha','바나나',27)
	public int testInsert(Map<String,Object> pMap) {
		logger.info("testInsert 호출 성공"+ pMap);
		int result = 0;
		try {
			//true로 설정하면 자동 커밋이 일어나니까 sqlsession.commit()호출하지 않아도 된다
			sqlSession = sqlSessionFactory.openSession(false);//default false 이다 자동커밋 모드가 꺼져 있다
			pMap = new HashMap<>();
			pMap.put("id",21);
			pMap.put("name","바나나");
			pMap.put("age",27);
			//result = tDao.testInsert(pMap);
			result = sqlSession.insert("testInsert", pMap);
			logger.info("result: "+result);
			//파라미터가 false인 경우 반드시 커밋 함수를 호출해야 오라클 서버에 반영된다.
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			//사용한 자원 반납하기
			sqlSession.close();
		}
		return result;
	}
	
	//UPDATE test SET name = '딸기' WHERE id = 'nice'
	/*
	 <update id="testUpdate" parameterType="map">
		UPDATE test 
		   SET 
		<if test="name !=null">
		       name = #{name},	
		</if>	   
		       age = #{age}
		 WHERE id = #{id} 	
	 </update>	
	*/
	public int testUpdate(Map<String,Object> pMap) {
		logger.info("testUpdate 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			pMap = new HashMap<>();
			pMap.put("id",21);
			//pMap.put("name","바나나2");
			pMap.put("age",273);
			result = sqlSession.update("testUpdate", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			//사용한 자원 반납하기
			sqlSession.close();
		}
		return result;
	}
	//DELETE FROM test WHERE id = 'nice'
	public int testDelete(String id) {
		logger.info("testDelete 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("testDelete", id);
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			//사용한 자원 반납하기
			sqlSession.close();
		}
		return result;
	}
	public static void main(String args[]) {
		TestDao tDao = new TestDao();
		//입력 수정 삭제 처리 결과를 담을 변수 선언
		int result = 0;
		//INSERT INTO test(id,name,age) VALUES('haha','바나나',27)
		Map<String,Object> pMap = new HashMap<>();
//		pMap.put("id","haha");
//		pMap.put("name","바나나");
//		pMap.put("age",27);
//		result = tDao.testInsert(pMap);
//		pMap = null;//Candidate상태로 넘어감
//		pMap = new HashMap<>();//새로운 주소번지가 할당
//		pMap.put("id","nice");
//		pMap.put("name","귤");
//		pMap.put("id","nice");
		result = tDao.testUpdate(pMap);
//		result = tDao.testDelete(pMap);
//		if(result == 1) {
//			tDao.testList(null);
//		}
		System.out.println("result ===> "+result);
	}	
}
