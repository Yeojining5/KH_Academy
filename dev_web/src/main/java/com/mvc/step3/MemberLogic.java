package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
// MVC패턴에 대한 이해, 구조분석, 소스리뷰
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberDao = new MemberDao();
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> memberList = null;
		memberList = memberDao.memberList(pMap);
		return memberList; 
	}

}
