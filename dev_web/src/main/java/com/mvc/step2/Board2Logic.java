package com.mvc.step2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board2Logic {
	Logger logger = Logger.getLogger(Board2Logic.class);
	Board2Dao boardDao = new Board2Dao();
	public List<Map<String,Object>> boardList(){
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardDao.boardList();
		return boardList;
	}
}
