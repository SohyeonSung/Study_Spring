package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		System.out.println(" [BoardServiceClient] >> 스프링 컨테이너 구동 전");
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println(" [BoardServiceClient] >> 스프링 컨테이너 구동 후");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		
		// INSERT
		BoardVO vo = new BoardVO();
		vo.setTitle("제목 Spring");
		vo.setWriter("홍길동 Spring");
		vo.setContent("내용 Spring");
		
		boardService.insertBoard(vo);
		
		
		List<BoardVO> list = boardService.getBoardList();
		System.out.println("list :  " + list);
		System.out.println("list.size() :  " + list.size());

		for (BoardVO board : list) {
			System.out.println(board);
		}
		
		
		
		
		System.out.println(" [BoardServiceClient] >> 스프링 컨테이너 종료 (close)");
		container.close();
		
		
	}

}