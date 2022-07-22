package com.mvc.step1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BoardController implements Action {
	Logger logger = Logger.getLogger(BoardController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute 호출 성공");
		ActionForward af = new ActionForward();
		String command = req.getParameter("gubun");
		StringBuilder path = new StringBuilder();
		path.append("/board-step1/");
		logger.info("command ===> "+command);
		boolean isRedirect = false;//true- sendRedirect false: forward: 유지-select
		//글쓰기
		if("insert".equals(command)) {
			
		}
		//글수정
		else if("update".equals(command)) {
			
		}
		//글삭제
		else if("delete".equals(command)) {
			
		}
		//글조회
		else if("select".equals(command)) {
			List<Map<String,Object>> boardList = new ArrayList<>();
			// 선언부와 생성부의 타입이 다를때 다형성-폴리모피즘
			// rmap으로 자손의 메소드는 호출이 불가함
			Map<String, Object> rmap = new HashMap<>();
			rmap.put("코치명", "치타");
			rmap.put("수업유형", "A형(90분)");
			rmap.put("hp", "010-555-8888");
			boardList.add(rmap);
			req.setAttribute("boardList", boardList);
			path.append("boardList.jsp");
			
		}
		af.setPath(path.toString());
		af.setRedirect(isRedirect);
		return af;
	}

}
