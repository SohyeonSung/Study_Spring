package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired // 타입 일치 객체 주입
	private BoardDAO boardDAO; // MyBatis
	
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 객체 생성");
	}

//	@Autowired // 설정하지 않아도 자동 주입(4.3.x 부터)
//	public BoardServiceImpl(BoardDAO boardDAO) {
//		System.out.println(">> BoardServiceImpl(BoardDAOSpring) 객체 생성");
//		this.boardDAO = boardDAO;
//	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		return boardDAO.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}












