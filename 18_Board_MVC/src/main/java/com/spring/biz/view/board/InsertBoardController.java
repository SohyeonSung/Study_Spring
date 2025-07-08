package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.view.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">> 게시글 입력 처리");
		//1. 전달받은 데이터 확인
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//2. DB연동작업(INSERT)
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		//3. 화면 네비게이션(화면전환, 화면이동)
		//response.sendRedirect("getBoardList.do");
		
		return "getBoardList.do";
	}

}
