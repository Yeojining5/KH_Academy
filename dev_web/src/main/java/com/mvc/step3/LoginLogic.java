package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class LoginLogic {
	Logger logger = Logger.getLogger(LoginLogic.class);
	LoginDao loginDao = new LoginDao();
	public String login(Map<String, Object> pMap){
		logger.info("login 호출 성공");
		String s_mem_name = null;
		s_mem_name = loginDao.login(pMap);
		return s_mem_name; 
	}
}
