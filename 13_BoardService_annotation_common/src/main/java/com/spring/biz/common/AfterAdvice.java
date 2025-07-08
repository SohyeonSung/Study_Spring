package com.spring.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//(실습) @Service, @Aspect, @Pointcut, @After
@Aspect
@Service
public class AfterAdvice {
	
	@After("PointcutCommon.allPointcut()")
	public void afterLog() {
		System.out.println("[후처리-AfterAdvice.afterLog] "
				+ "비즈니스 로직 수행후 로그(언제나, 무조건)");
	}
}







