package mvc.kh;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.vo.Board;
import model.vo.Board2;

public class BoardDetailServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardDetailServlet.class);
	BoardService boardService = new BoardService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		int id = 0;
		id = Integer.parseInt(req.getParameter("id"));
		Board2 board2 = null;
		board2 = boardService.boardDetail(id);
		/*
		board2 = new Board2();
		board2.setTbId(1);
		board2.setTbTitle("글제목1");
		board2.setTbWriter("이순신");
		board2.setTbContent("글내용1");
		*/
		req.setAttribute("board2", board2);
		RequestDispatcher view = req.getRequestDispatcher("/board2/boardUpdateForm.jsp");
		view.forward(req, res);		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}	
}
