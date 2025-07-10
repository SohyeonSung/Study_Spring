package com.spring.biz.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@SessionAttributes("board") // board 라는 이름의 Model 있으면 session 에 저장
@Controller
public class BoardController {
	
	// 메소드에 선언된 @ModelAttribute 는 리턴된 데이터를 View 에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드 보다 먼저 실행
	// 뷰에 전달될 때 설정된 명칭(예: conditionMap)
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("====> Map searchConditionMap() 실행 ================");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO dao, Model model) {
		System.out.println(">> 게시글 1개 조회(상세보기)-------------");
		System.out.println("vo : " + vo);
		
		BoardVO board = dao.getBoard(vo);
		System.out.println("DB조회 후 board : " + board);
		
		model.addAttribute("board", board); // Model 객체 사용 View로 데이터 전달
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model){
		System.out.println(">> 게시글 전체 목록 보여주기 -----------------");
		System.out.println("> vo : " + vo);
		
		//1. 게시글 목록 조회(SELECT)
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">> 게시글 입력 처리 -------------------");
		System.out.println("vo : " + vo);

		boardDAO.insertBoard(vo);
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	
	// @ModelAttribute("board") : @SessionAttributes 설정으로 존재하는 "board" 데이터 사용
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">> 게시글 수정 처리------------------");
		System.out.println("vo : " + vo);
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO,
			SessionStatus sessionStatus) {
		System.out.println(">> 게시글 삭제 처리---------------");
		System.out.println("vo : " + vo);

		boardDAO.deleteBoard(vo);
		sessionStatus.setComplete(); // @SessionAttributes 설정 데이터 모두 삭제
		
		return "redirect:getBoardList.do";
	}

	
}
