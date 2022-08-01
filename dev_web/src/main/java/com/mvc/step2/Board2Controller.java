package com.mvc.step2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// 반드시 ActionServlet을 경유한 뒤 Board2Controller가 실행되어야 함
// 왜냐 Board2Controller가 서블릿이 아니니까
public class Board2Controller implements Controller {
	Logger logger = Logger.getLogger(Board2Controller.class);
	Board2Logic boardLogic = new Board2Logic();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("execute 호출 성공");
		String upmu[] = (String[])req.getAttribute("upmu");
		logger.info(upmu[0]+","+upmu[1]);
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList();
		
		return "";
	}

}
