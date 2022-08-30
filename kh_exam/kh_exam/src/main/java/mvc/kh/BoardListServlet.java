package mvc.kh;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.vo.Board;

public class BoardListServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardListServlet.class);
	JDBCTemplate jt = JDBCTemplate.getInstance();
	Connection conn = null;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		conn = jt.getConnect();
		List<Board> boardList = null;
		BoardDao boardDao = new BoardDao();
		boardList = boardDao.selectBoard(conn);
		req.setAttribute("boardList", boardList);
		RequestDispatcher view = req.getRequestDispatcher("/board/boardList.jsp");
		view.forward(req, res);		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}	
}
