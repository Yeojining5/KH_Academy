package com.mvc.step2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board2Dao {
	Logger logger = Logger.getLogger(Board2Dao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public Board2Dao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public List<Map<String, Object>> boardList() {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList");
			// insert here
			logger.info(boardList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return boardList;
	}/////////////// end of boardList

}
