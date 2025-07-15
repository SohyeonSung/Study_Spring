package com.spring.biz.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.biz.board.BoardVO;

/* @Mapper 사용방식
메소드 정의가 매퍼(mapper)파일의 SQL 정의와 연결됨
- 리턴타입 : SQL 실행 결과 저장 타입(resultType)
- 메소드명 : SQL 문장의 id명으로 적용
- 파라미터값 : SQL 의 parameterType 적용
*/
@Mapper
public interface BoardDAO {
	// CRUD 기능 구현 메소드 정의
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
}












