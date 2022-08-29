package com.mvc.step3;

import java.util.Map;

import org.apache.log4j.Logger;

public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);
	public String login(Map<String, Object> pMap) {
		logger.info("login 호출 성공");
		
		return null;
	}

}
