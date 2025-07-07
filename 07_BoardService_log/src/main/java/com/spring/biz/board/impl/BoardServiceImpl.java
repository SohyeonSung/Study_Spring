package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.common.Log4jAdvice;
import com.spring.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
		private BoardDAO boardDAO;
		// private LogAdvice log;
		private Log4jAdvice log4j;
	
	//@Autowired 설정하지 않아도 자동 주입(4.3 버전 이상)
	public BoardServiceImpl(BoardDAO boardDAO) {
		System.out.println(" [BoardServiceImpl] >> BoardServiceImpl(BoardDAO) 객체 생성");
		this.boardDAO = boardDAO;
		log4j = new Log4jAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		log4j.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		log4j.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		log4j.printLogging();
		return boardDAO.getBoardList();
	}

}
