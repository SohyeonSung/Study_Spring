package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;


import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;


//(실습) 객체 생성 어노테이션 설정
@Repository
public class UserDAO {
	
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	// UserTest -> SQL 입력 테스트
	private final String USER_INSERT = "INSERT INTO USERS (ID, PASSWORD, NAME, ROLE)"
									+ "VALUES (?, ?, ?, ?)";
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	
	
	// INSERT
		public void insertUser(UserVO vo) {
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(USER_INSERT);
				stmt.setString(1, vo.getId());
				stmt.setString(2, vo.getPassword());
				stmt.setString(3, vo.getName());
				stmt.setString(4, vo.getRole());

				int result = stmt.executeUpdate();
				System.out.println(" [UserDAO] >> JDBC로 insertUser() 실행");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt);
			}
		}
	

	// GET (단일 조회)
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			System.out.println(" [UserDAO] >> JDBC로 getUser() 실행");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return user;
	}

	
}
