package com.mvc.step3;

import java.util.Map;

import org.apache.log4j.Logger;

public class AuthLogic {
	Logger logger = Logger.getLogger(AuthLogic.class);
	AuthDao authDao = new AuthDao();
	public String login(Map<String, Object> pMap) {
		logger.info("login 호출 성공");
		String s_name = null;
		s_name = authDao.login(pMap);
		return s_name;
	}
}
