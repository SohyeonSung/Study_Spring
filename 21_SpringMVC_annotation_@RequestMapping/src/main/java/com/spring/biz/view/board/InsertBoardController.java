package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	@RequestMapping("/insertBoard.do")
	public ModelAndView insertBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav)
			throws ServletException, IOException {
		System.out.println(">> 게시글 입력 처리 -------------------");
		
		
		// 2. DB 연동하여 게시글 추가
		boardDAO.insertBoard(vo);
		
		// 3. 목록 화면으로 리다이렉트
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}










