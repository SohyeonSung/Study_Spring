package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;


@Repository
public class BoardDAO {

	// JDBC 관련 변수 (필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public BoardDAO() {
			System.out.println(" [BoardDAO] >> BoardDAO() 객체 생성");
	}

	// BoardTest -> SQL 입력 테스트
	private final String BOARD_INSERT = "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)"
			+ "VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";



	// INSERT
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());

			int result = stmt.executeUpdate();
			System.out.println(" [BoardDAO] >> JDBC로 insertBoard() 실행");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	
	// UPDATE
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());

			int result = stmt.executeUpdate();
			System.out.println(" [BoardDAO] >> JDBC로 updateBoard() 실행");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	
	// DELETE
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());

			int result = stmt.executeUpdate();
			System.out.println(" [BoardDAO] >> JDBC로 deleteBoard() 실행");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	
	// GET (단일 조회)
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());

			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
			System.out.println(" [BoardDAO] >> JDBC로 getBoard() 실행");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return board;
	}

	
	// LIST (전체 조회)
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));

				boardList.add(board);
			}
			System.out.println(" [BoardDAO] >> JDBC로 getBoardList() 실행");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return boardList;
	}
}