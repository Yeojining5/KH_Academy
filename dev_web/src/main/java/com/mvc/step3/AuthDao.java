package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class AuthDao {
	Logger logger = Logger.getLogger(AuthDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;
	public AuthDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public MemberVO login(Map<String, Object> pMap) {
		logger.info("login 호출 성공 : "+pMap);
		MemberVO mVO = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			// 여기서  One 은 Object를 의미함 - 한개 row만 담을 수 있다.
			mVO = sqlSession.selectOne("login", pMap);
			// insert here
			logger.info(mVO.getMem_name());
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return mVO;
	}

}
