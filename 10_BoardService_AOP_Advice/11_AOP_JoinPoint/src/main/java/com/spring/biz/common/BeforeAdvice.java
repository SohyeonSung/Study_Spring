package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class BeforeAdvice {
//	public void beforeLog() {
//		System.out.println("[전처리-BeforeAdvice.beforeLog] "
//				+ "비즈니스 로직 수행전 로그");
//	}
	
	public void beforeLog(JoinPoint jp) {
		Signature signature =  jp.getSignature();
		String methodName = signature.getName();
		String declaringTypeName = signature.getDeclaringTypeName();
		System.out.println("declaringTypeName : " + declaringTypeName);
		System.out.println("signature.toShortString() : " + signature.toShortString());
		System.out.println("signature.toLongString() : " + signature.toLongString());
		
		Object[] args = jp.getArgs();
		System.out.println("args : " + Arrays.toString(args));
		
		System.out.println("[전처리] " + methodName + "() 메소드-"
				+ "비즈니스 로직 수행전 로그");
	}
	
}
