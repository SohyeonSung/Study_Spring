package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect // 포인트 컷 + 어드바이스 연결
@Service // 객체(인스턴스) 생성
public class BeforeAdvice {

	// 어드바이스 동작시점 설정 + 포인트 컷 지정
	@Before("PointcutCommon.allPointcut()") //메소드 호출 형식으로 사용
	public void beforeLog() { //어드바이스 메소드
		System.out.println("[전처리-BeforeAdvice.beforeLog] "
				+ "비즈니스 로직 수행전 로그");
	}
	
}








