package com.spring.biz.common;

import java.lang.reflect.Executable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AfterThrowingAdvice {
	
	@AfterThrowing(pointcut = "PointcutCommon.allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		System.out.println("[후처리-AfterThrowingAdvice.exceptionLog] "
				+ "예외발생 로그 " + exceptObj);
	}
}








