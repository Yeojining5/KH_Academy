package mvc.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.vo.Board;
import model.vo.Board2;

public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public int updateBoard(Connection con, Board2 board2) {
		logger.info("updateBoard 호출 성공");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("update khboard set title=?");
		sql.append("                ,content=?");
		sql.append(" where22222 id=?");
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board2.getTbTitle());
			pstmt.setString(2, board2.getTbContent());
			pstmt.setInt(3, board2.getTbId());
			result = pstmt.executeUpdate();
			logger.info("result : "+result);
		} catch (SQLException se) {
			logger.info("[[query]] : "+sql.toString());
			//if문에서 return을 빠져나감
			result = 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public int insertBoard(Connection conn, Board board) {
		logger.info("insertBoard 호출 성공");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO board(boardnum, boardwriter, boardtitle, boardcontent, boarddate)");
		sql.append(" VALUES(seq_board_no.nextval,?,?,?,to_char(sysdate, 'YYYY-MM-DD'))");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			int i=0;
			pstmt.setString(++i, board.getBoardWriter());
			pstmt.setString(++i, board.getBoardTitle());
			pstmt.setString(++i, board.getBoardContent());
			result = pstmt.executeUpdate();
			logger.info("result가 1이면 등록 성공 0이면 실패 ===> "+ result);
		} catch (SQLException se) {
			logger.info(se.toString());
			logger.info("[query] "+sql.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return result;
	}
	public List<Board> selectBoard(Connection conn) {
		logger.info("selectBoard 호출 성공");
		List<Board> boardList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT boardnum, boardwriter, boardtitle, boardcontent, boarddate");
		sql.append(" FROM board");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Board board = null;
			while(rs.next()) {
				board = new Board();
				board.setBoardNum(rs.getInt("boardnum"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardContent(rs.getString("boardcontent"));
				boardList.add(board);
			}
			logger.info("boardList ===> "+ boardList);
		} catch (SQLException se) {
			logger.info(se.toString());
			logger.info("[query] "+sql.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return boardList;		
	}
	public Board2 boardDetail(Connection conn, int id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, writer, title, content");
		sql.append(" FROM khboard");
		sql.append(" WHERE id=?");
		Board2 board2 = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board2 = new Board2();
				board2.setTbId(rs.getInt("id"));
				board2.setTbTitle(rs.getString("title"));
				board2.setTbWriter(rs.getString("writer"));
				board2.setTbContent(rs.getString("content"));
			}
			logger.info("board2 ===> "+ board2.getTbTitle()+", "+board2.getTbContent());
		} catch (SQLException se) {
			logger.info(se.toString());
			logger.info("[query] "+sql.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return board2;
	}

}
