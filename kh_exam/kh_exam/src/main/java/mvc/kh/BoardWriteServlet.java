package mvc.kh;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.vo.Board;


public class BoardWriteServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardWriteServlet.class);
	BoardService boardService = new BoardService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		String boardTitle​​ = req.getParameter("boardTitle​​");
		String boardWriter = req.getParameter("boardWriter");
		String boardContent = req.getParameter("boardContent");
		logger.info(boardTitle​​+", "+boardWriter+", "+boardContent);
		int result = 0;
		Board board = new Board();
		board.setTitle(boardTitle​​);
		board.setWriter(boardWriter);
		board.setContent(boardContent);
		//BoardDao boardDao = new BoardDao();
//		result = boardDao.insertBoard(conn,board);
		result = boardService.insertBoard(board);
		if(result==1) res.sendRedirect("/board/boardList.jsp");
		else res.sendRedirect("/board/boardWriteFail.jsp");		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");
		String boardTitle​​ = req.getParameter("boardTitle​​");
		String boardWriter = req.getParameter("boardWriter");
		String boardContent = req.getParameter("boardContent");
		logger.info(boardTitle​​+", "+boardWriter+", "+boardContent);
		int result = 0;
		Board board = new Board();
		board.setTitle(boardTitle​​);
		board.setWriter(boardWriter);
		board.setContent(boardContent);
		result = boardService.insertBoard(board);
		if(result==1) res.sendRedirect("boardList.jsp");
		else res.sendRedirect("/board/boardWriteFail.jsp");
	}	
}
