package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {
//	public void afterReturnLog() {
//		System.out.println("[후처리-AfterReturningAdvice.afterReturnLog] "
//				+ "비즈니스 로직 수행후 로그(정상실행시)");
//	}
	
	// returnObj : 추가 바인드변수를 사용시에는 스프링 설정파일에 설정
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		
		
		System.out.println("[후처리-정상실행] " + methodName + "() 메소드, "
				+ "리턴값 : " + returnObj);
	}
}









