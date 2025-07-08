package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.board.impl.BoardServiceImpl;

public class BoardTest {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardService boardService = new BoardServiceImpl(dao);
		
		System.out.println("--- 작업전 데이터 검색 ----");
		List<BoardVO> list = boardService.getBoardList();
		
		for (BoardVO board : list) {
			System.out.println(board);
		}
		
		System.out.println("--- 게시글 1개 조회 -----");
		BoardVO selectVO = new BoardVO();
		selectVO.setSeq(1);
		System.out.println(boardService.getBoard(selectVO));
		
		System.out.println("--- INSERT -----");
		BoardVO vo = new BoardVO();
		vo.setTitle("제목-테스트-new");
		vo.setWriter("홍길동2");
		vo.setContent("내용-테스트-new");
		
		System.out.println("입력할 게시글 : " + vo);
		boardService.insertBoard(vo);
		
		System.out.println("--- 입력 후 전체데이터 검색 ----");
		list = boardService.getBoardList();
		
		for (BoardVO board : list) {
			System.out.println(board);
		}
/*		
		System.out.println("--- UPDATE -----");
		vo.setSeq(list.get(0).getSeq());
		vo.setTitle("제목-수정");
		vo.setContent("내용-수정");
		boardService.updateBoard(vo);
		System.out.println("수정결과 : " + boardService.getBoard(vo));
		
		System.out.println("--- DELETE -----");
		boardService.deleteBoard(vo);
		System.out.println("삭제후 조회결과 : " + boardService.getBoard(vo));
*/		
	}

}
