package mvc.kh;

import java.sql.Connection;

import org.apache.log4j.Logger;

import model.vo.Board;
import model.vo.Board2;

public class BoardService {
	Logger logger = Logger.getLogger(BoardService.class);
	BoardDao boardDao = new BoardDao();
	JDBCTemplate jt = JDBCTemplate.getInstance();
	Connection conn = null;
	public int insertBoard(Board board) {
		logger.info("insertBoard 호출 성공");
		conn = jt.getConnect();
		int result = 0;
		result = boardDao.insertBoard(conn, board);
		return result;
	}
	public int updateBoard(Board2 board2) {
		int result = 0;
		conn = jt.getConnect();
		logger.info("updateBoard 호출 성공");
		result = boardDao.updateBoard(conn, board2);
		return result;
	}
	public Board2 boardDetail(int id) {
		conn = jt.getConnect();
		Board2 board2 = null;
		board2 = boardDao.boardDetail(conn,id);
		return board2;
	}
}
