package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//@Autowired // 타입 일치 객체 주입
	//private BoardDAO boardDAO;
	private BoardDAOSpring boardDAO;
	
//	public BoardServiceImpl() {
//		System.out.println(">> BoardServiceImpl() 객체 생성");
//	}

	//@Autowired 설정하지 않아도 자동 주입(4.3.x 부터)
	public BoardServiceImpl(BoardDAOSpring boardDAO) {
		System.out.println(">> BoardServiceImpl(BoardDAOSpring) 객체 생성");
		this.boardDAO = boardDAO;
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		vo.setSeq(100);
		boardDAO.insertBoard(vo); //입력 성공
		System.out.println(":: 첫번째 입력처리 후");
		
		vo.setSeq(100);
		boardDAO.insertBoard(vo); //입력 실패
		System.out.println(":: 두번째 입력처리 후");
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}

}
