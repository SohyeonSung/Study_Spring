package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardDAO() {
		System.out.println(">> BoardDAO() 객체 생성");
	}
	
	public int insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis 사용 insertBoard() 실행");
		return mybatis.insert("boardDAO.insertBoard", vo);
	}

	public int updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis 사용 updateBoard() 실행");
		return mybatis.update("boardDAO.updateBoard", vo);
	}

	public int deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis 사용 deleteBoard() 실행");
		return mybatis.delete("boardDAO.deleteBoard", vo);
	}

	//글 1개 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis 사용 getBoard() 실행");
		
		return mybatis.selectOne("boardDAO.getBoard", vo);
	}

	//글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis 사용 getBoardList(BoardVO) 실행");
		// 검색조건 값이 없을 때 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		return mybatis.selectList("boardDAO.getBoardList", vo);
	}
	
	//글 목록 조회
	public List<BoardVO> getBoardList2(BoardVO vo) {
		System.out.println("===> MyBatis 사용 getBoardList(BoardVO) 실행");
		// 검색조건 값이 없을 때 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		if ("TITLE".equals(vo.getSearchCondition())) {
			 return mybatis.selectList("boardDAO.getBoardList_T", vo.getSearchKeyword());
		} else {
			return mybatis.selectList("boardDAO.getBoardList_C", vo.getSearchKeyword());
		}
	}
	
	
}







