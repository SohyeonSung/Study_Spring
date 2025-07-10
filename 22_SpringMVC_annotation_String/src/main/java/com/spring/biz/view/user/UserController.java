package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

//@Controller : DispatcherServlet 에서 인식할 수 있는 컨트롤러 객체 생성
@Controller
public class UserController {

	/* @RequestMapping, Command 객체
	@RequestMapping : 요청과 처리(Controller) 연결(HandlerMapping 역할 대체)
	Command 객체 사용 : 파라미터로 전달되는 데이터를 자바빈에 설정
	1. UserVO 타입 객체 생성
	2. UserVO 타입 객체에 전달받은 파라미터 값을 설정(명칭 일치)
	3. UserVO 타입 객체를 메소드의 파라미터 값으로 전달(주입)
	*/
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">> 로그인 처리 ----------------");
		System.out.println("vo : " + vo);

		UserVO user = userDAO.getUser(vo);
		
		if (user != null) {
			System.out.println(">> 로그인 성공!!");
			return "redirect:getBoardList.do";
		} else {
			System.out.println(">> 로그인 실패~~~");
			return "login.jsp";
		}
	}	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">> 로그아웃 처리 ---------------");
		//1. 세션 초기화(무효화)
		session.invalidate();
		
		//2. 화면 네비게이션(화면이동)
		return "login.jsp";
	}
	
}













