package com.spring.biz.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">> DispatcherServlet process() : *.do 요청처리~~");
		
		//1. 클라이언트에서 어떤 작업을 요청했는지 확인하기
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri); //  /biz/login.do
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath); // /biz
		
		String path = uri;
		if (uri.indexOf(contextPath) == 0) {
			path = uri.substring(contextPath.length());
		}
		System.out.println("path : " + path);
		
		//2. 클라이언트 요청형태에 따른 작업 처리
		Controller controller = handlerMapping.getController(path);
		System.out.println(":: controller : " + controller);
		
		String viewName = controller.handleRequest(request, response);
		System.out.println(":: viewName : " + viewName);
		
		//응답처리
		response.sendRedirect(viewName);
		
/*		
		//2. 클라이언트 요청형태에 따른 작업 처리
		if ("/login.do".equals(path)) {
			System.out.println(">> 로그인 처리");
			//1. 사용자가 전달한 데이터(정보) 확인(추출)
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			System.out.println("id: " + id + ", password: " + password);
			
			//2. DB연동작업(사용자 정보 유무 확인)
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. 화면 네비게이션(화면전환, 화면이동)
			// 로그인 성공 : 게시글 목록 보여주기
			// 로그인 실패 : 로그인 화면으로 이동
			if (user != null) {
				System.out.println(">> 로그인 성공!!");
				response.sendRedirect("getBoardList.do");
			} else {
				System.out.println(">> 로그인 실패~~~");
				response.sendRedirect("login.jsp");
			}
		}
		if ("/logout.do".equals(path)) {
			System.out.println(">> 로그아웃 처리");
			//1. 세션 초기화(무효화)
			HttpSession session = request.getSession();
			session.invalidate();
			//2. 화면 네비게이션(화면이동)
			response.sendRedirect("login.jsp");
		}
		if ("/getBoardList.do".equals(path)) {
			System.out.println(">> 게시글 전체 목록 보여주기");
			//1. 게시글 목록 조회(SELECT)
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList();
			
			//2. 뷰에서 사용토록 데이터 전달
			//HttpSession session = request.getSession();
			//session.setAttribute("boardList", boardList);
			request.getSession().setAttribute("boardList", boardList);
			
			//목록 화면 이동
			response.sendRedirect("getBoardList.jsp");
		}
		if ("/getBoard.do".equals(path)) {
			System.out.println(">> 게시글 1개 조회(상세보기)");
			//1. 전달받은 데이터 확인
			String seq = request.getParameter("seq");
			
			//2. 게시글 1개 조회(SELECT)
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			//2. 뷰에서 사용토록 데이터 전달
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//목록 화면 이동
			response.sendRedirect("getBoard.jsp");
		}
		if ("/insertBoard.do".equals(path)) {
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
			response.sendRedirect("getBoardList.do");
		}
		if ("/updateBoard.do".equals(path)) {
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
			response.sendRedirect("getBoardList.do");
		}
		if ("/deleteBoard.do".equals(path)) {
			System.out.println(">> 게시글 삭제 처리");
			//1. 전달받은 데이터 확인
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			//2. DB연동작업(DELETE)
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			//3. 화면 네비게이션(화면전환, 화면이동)
			response.sendRedirect("getBoardList.do");
		}
*/
		
	} //end process 

} //end class








