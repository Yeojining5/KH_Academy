package mvc.kh;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
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
		board.setBoardTitle(boardTitle​​);
		board.setBoardWriter(boardWriter);
		board.setBoardContent(boardContent);
		//BoardDao boardDao = new BoardDao();
//		result = boardDao.insertBoard(conn,board);
		result = boardService.insertBoard(board);
		result = 0;
		if(result==1) res.sendRedirect("/kh_exam/board/boardList");
		else{
			req.setAttribute("message", "게시글 등록 실패");
			RequestDispatcher view = 
					req.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			view.forward(req, res);
		}	
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
		board.setBoardTitle(boardTitle​​);
		board.setBoardWriter(boardWriter);
		board.setBoardContent(boardContent);
		result = boardService.insertBoard(board);
		if(result==1) res.sendRedirect("boardList.jsp");
		else res.sendRedirect("/board/boardWriteFail.jsp");
	}	
}
