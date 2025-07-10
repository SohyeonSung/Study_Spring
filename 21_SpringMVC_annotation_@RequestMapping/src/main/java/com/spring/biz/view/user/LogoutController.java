package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

    @RequestMapping("/logout.do")
    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        System.out.println(">> 로그아웃 처리");

        // 1. 세션 무효화
        session.invalidate();

        // 2. 로그인 페이지로 이동
        mav.setViewName("login.jsp");

        return mav;
    }
}






