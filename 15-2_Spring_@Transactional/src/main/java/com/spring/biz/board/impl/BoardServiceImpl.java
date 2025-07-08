package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

//@Transactional // 모든 메소드가 트랜잭션 대상 처리
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
	
	@Transactional // 현재 메소드만 트랜잭션 처리
	@Override
	public void insertBoard(BoardVO vo) {
		vo.setSeq(200);
		boardDAO.insertBoard(vo); //입력 성공
		System.out.println(":: 첫번째 입력처리 후");
		
		vo.setSeq(200);
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
