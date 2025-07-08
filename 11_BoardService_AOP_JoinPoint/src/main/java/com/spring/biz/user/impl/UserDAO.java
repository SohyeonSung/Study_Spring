package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

//(실습) 객체 생성 어노테이션 설정
@Repository
public class UserDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL 문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserDAO() {
		System.out.println(">> UserDAO() 객체 생성");
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return null;
	}

	
}
