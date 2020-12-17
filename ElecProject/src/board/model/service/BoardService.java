package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDAO;


public class BoardService {

	private BoardDAO boardDAO = new BoardDAO();

	public int insertBoard(String memberId, String boardContent, int boardGrade, String prodCode) {
		Connection conn = getConnection();
		int result = boardDAO.insertBoard(conn, memberId, boardContent, boardGrade, prodCode);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}
