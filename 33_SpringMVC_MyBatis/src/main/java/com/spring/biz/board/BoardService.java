package com.spring.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD 기능 구현 메소드 정의
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
}





