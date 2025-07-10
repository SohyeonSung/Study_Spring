package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

@Repository
public class BoardDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public BoardDAO() {
		System.out.println(">> BoardDAO() 객체 생성");
	}
	
	//SQL 문
	private final String BOARD_INSERT
		= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)"
		+ "VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE
		= "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return null;
	}

	public List<BoardVO> getBoardList(String condition, String keyword) {
	    System.out.println("===> JDBC로 getBoardList(condition, keyword) 실행");

	    List<BoardVO> boardList = new ArrayList<>();

	    try {
	        conn = JDBCUtil.getConnection();

	        String sql;

	        // 검색 조건이 없는 경우 (전체 목록 조회)
	        if (condition == null || condition.isEmpty() || keyword == null || keyword.isEmpty()) {
	            sql = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	            stmt = conn.prepareStatement(sql);
	        }
	        // 검색 조건이 있는 경우
	        else if ("TITLE".equals(condition)) {
	            sql = "SELECT * FROM BOARD WHERE TITLE LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, keyword);
	        } else if ("CONTENT".equals(condition)) {
	            sql = "SELECT * FROM BOARD WHERE CONTENT LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, keyword);
	        } else {
	            // 기타 조건 처리: 제목 + 내용 검색
	            sql = "SELECT * FROM BOARD WHERE TITLE LIKE '%' || ? || '%' OR CONTENT LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, keyword);
	            stmt.setString(2, keyword);
	        }

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

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(conn, stmt, rs);
	    }

	    return boardList;
	}

}

	
	
	
	
	

