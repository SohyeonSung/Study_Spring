package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">> 게시글 1개 조회(상세보기)");
		//1. 전달받은 데이터 확인
		String seq = request.getParameter("seq");
		
		//2. 게시글 1개 조회(SELECT)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//2. 뷰에서 사용토록 데이터 전달
		//HttpSession session = request.getSession();
		//session.setAttribute("board", board);
		
		//목록 화면 이동
		//response.sendRedirect("getBoard.jsp");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); // Model 에 데이터 저장
		mav.setViewName("getBoard.jsp"); // View 에 뷰명칭 저장
		
		return mav;
	}

}








