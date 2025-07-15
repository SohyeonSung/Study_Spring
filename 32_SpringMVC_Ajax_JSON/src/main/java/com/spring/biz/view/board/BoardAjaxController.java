package com.spring.biz.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

//@Controller
@RestController // 클래스의 내의 요청처리 결과가 모두 @ResponseBody 처리됨
public class BoardAjaxController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/getJsonBoardList.do", method = RequestMethod.GET)
	//@ResponseBody // response 응답객체의 몸체(body)에 데이터 전달
	public List<BoardVO> getAjaxBoardList(BoardVO vo) {
		System.out.println("------> BoardAjaxController getAjaxBoardList(BoardVO) 실행");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("boardList : " + boardList);
		
		return boardList;
	}
	
	//@RequestMapping(value = "/getJsonBoard.do", method = RequestMethod.POST)
	@PostMapping(value = "/getJsonBoard.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//@ResponseBody // response 응답객체의 몸체(body)에 데이터 전달
	public BoardVO getJsonBoard(@RequestBody BoardVO vo) { // @RequestBody post방식 전달데이터 처리
		System.out.println("------> BoardAjaxController getJsonBoard(BoardVO) 실행");
		System.out.println("vo : " + vo);
		BoardVO board = boardService.getBoard(vo);
		System.out.println("board : " + board);
		
		return board;
	}
	
	
}











