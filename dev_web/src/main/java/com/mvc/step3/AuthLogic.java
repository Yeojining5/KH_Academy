package com.mvc.step3;

import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.MemberVO;

public class AuthLogic {
	Logger logger = Logger.getLogger(AuthLogic.class);
	AuthDao authDao = new AuthDao();
	public MemberVO login(Map<String, Object> pMap) {
		logger.info("login 호출 성공");
		MemberVO mVO = null;
		mVO = authDao.login(pMap);
		return mVO;
	}
}
