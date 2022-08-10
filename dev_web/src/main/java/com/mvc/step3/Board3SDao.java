package com.mvc.step3;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

// 서브 테이블
public class Board3SDao {
	Logger logger = Logger.getLogger(Board3SDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public Board3SDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
}
