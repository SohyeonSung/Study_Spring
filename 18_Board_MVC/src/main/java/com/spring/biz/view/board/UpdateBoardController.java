package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.view.controller.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">> 게시글 수정 처리");
		//1. 전달받은 데이터 확인
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//2. DB연동작업(UPDATE)
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		//3. 화면 네비게이션(화면전환, 화면이동)
		//response.sendRedirect("getBoardList.do");
		
		return "getBoardList.do";
	}

}
