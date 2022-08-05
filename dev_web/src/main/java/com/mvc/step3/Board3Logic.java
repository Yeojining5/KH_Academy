package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mvc.step2.Board2Dao;
import com.mvc.step2.Board2Logic;

public class Board3Logic {
	Logger logger = Logger.getLogger(Board3Logic.class);
	Board3Dao boardDao = new Board3Dao();
	public List<Map<String,Object>> boardList(){
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardDao.boardList();
		return boardList;
	}
}
