package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		System.out.println("--- 스프링 컨테이너 구동전 ----");
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext_after-returning.xml");
		
		System.out.println("--- 스프링 컨테이너 구동후 ----");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목-spring");
		vo.setWriter("홍길동-spring");
		vo.setContent("내용-spring");
		
		boardService.insertBoard(vo);
		
		List<BoardVO> list = boardService.getBoardList();
		System.out.println("list.size() : " + list.size());
		for (BoardVO board : list) {
			System.out.println(board);
		}
		

		System.out.println("--- 스프링 컨테이너 종료(close) ----");
		container.close();
		
		
	}

}