package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">> 게시글 전체 목록 보여주기");
		//1. 게시글 목록 조회(SELECT)
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		//2. 뷰에서 사용토록 데이터 전달
		//request.getSession().setAttribute("boardList", boardList);
		
		//목록 화면 이동
		//response.sendRedirect("getBoardList.jsp");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model 에 데이터 저장
		mav.setViewName("getBoardList.jsp"); // View 명칭 저장

		return mav;
	}

}





