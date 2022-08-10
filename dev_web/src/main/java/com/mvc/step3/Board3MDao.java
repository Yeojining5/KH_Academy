package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board3MDao {
	Logger logger = Logger.getLogger(Board3MDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public Board3MDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	//쿼리문의 아이디와 메소드 이름은 통일함
	public int getBNo() {
		logger.info("getBNo 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getBNo");
			// insert here
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}/////////////// end of getBNo
	public int getBGroup() {
		logger.info("getBGroup 호출 성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getBGroup");
			// insert here
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}/////////////// end of getBGroup
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList", pMap);
			// insert here
			logger.info(boardList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return boardList;
	}/////////////// end of boardList
	/***********************************************************
	 * 댓글에 대한 댓글이 중간에 들어오는 경우 내 글 뒤에 댓글이 있다면
	 * read.jsp에서 가지고 있는 b_step보다 큰 값이 있을 것임
	 * 또한 같은 그룹의 글인 경우에 대해서만 처리해야 하므로 b_group 도 비교함
	 * @param pMap
	 * @return
	 ***********************************************************/
	public int bStepUpdate(Map<String, Object> pMap) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bStepUpdate",pMap);
			sqlSession.commit();
			logger.info("result : "+result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			//사용한 자원은 반드시 반납한다 - 묵시적으로 처리는 되지만 좀 더 서버의 부담을 덜기 위해 명시호출
			sqlSession.close();
		}		
		return result;
	}
	
	public int boardMUpdate(Map<String, Object> pMap) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMUpdate",pMap);
			sqlSession.commit();
			logger.info("result : "+result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}		
		return result;
	}
	
	public int boardMInsert(Map<String, Object> pMap) {
		int result = 0;
		try {
			//MapperConfig에 등록된 서버 정보를 통해 커넥션을 연결함
			sqlSession = sqlSessionFactory.openSession();
			//insert메소드 대신 update를 사용한 것은 selectKey라는 속성으로 
			//insert메소드의 리턴타입이 Object로 되어 있기 때문에 update를 
			//사용하였다. - delete를 사용해도 결과는 같다
			//사용자가 입력한 값을 HashMapBinder클래스를 통해서 Map에 담고
			//insert문을 호출할 때 파라미터로 넘김
			result = sqlSession.update("boardMInsert",pMap);
			//물리적인 테이블에 등록하는 것이니 반드시 커밋 할것... 주의....
			sqlSession.commit();
			// insert here
			logger.info("result : "+result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			//사용한 자원은 반드시 반납한다 - 묵시적으로 처리는 되지만 좀 더 서버의 부담을 덜기 위해 명시호출
			sqlSession.close();
		}		
		return result;
	}
	
	
}
