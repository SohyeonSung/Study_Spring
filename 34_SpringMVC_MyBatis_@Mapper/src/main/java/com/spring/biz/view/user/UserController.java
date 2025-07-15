package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

//@Controller : DispatcherServlet 에서 인식할 수 있는 컨트롤러 객체 생성
@Controller
public class UserController {
	//@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("===>> UserController() 객체 생성");
	}
	
	@Autowired
	public UserController(UserService userService) {
		System.out.println("===>> UserController(UserService) 객체 생성");
		this.userService = userService;
	}
	
	/* @RequestMapping, Command 객체
	@RequestMapping : 요청과 처리(Controller) 연결(HandlerMapping 역할 대체)
	Command 객체 사용 : 파라미터로 전달되는 데이터를 자바빈에 설정
	1. UserVO 타입 객체 생성
	2. UserVO 타입 객체에 전달받은 파라미터 값을 설정(명칭 일치)
	3. UserVO 타입 객체를 메소드의 파라미터 값으로 전달(주입)
	*/
	//@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@PostMapping("/login.do")
	public String login(UserVO vo) {
		System.out.println(">> 로그인 처리 ----------------");
		System.out.println("vo : " + vo);

		//예외 테스트용 코드
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
		}
		
		UserVO user = userService.getUser(vo);
		
		if (user != null) {
			System.out.println(">> 로그인 성공!!");
			return "redirect:getBoardList.do";
		} else {
			System.out.println(">> 로그인 실패~~~");
			return "login.jsp";
		}
	}	
	
	/* @ModelAttribute : 모델(Model)의 속성값으로 저장(속성명 별도 지정)
	 * @ModelAttribute UserVO ---> 속성명 userVO 명칭 사용
	 * @ModelAttribute("user") UserVO ---> 속성명 user 사용
	 */
	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">> 로그인 화면 이동 - loginView()");
		System.out.println("vo : " + vo);
		vo.setId("test");
		vo.setPassword("test");
		
		return "login.jsp";
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













