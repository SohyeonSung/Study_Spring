package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		System.out.println("--- 스프링 컨테이너 구동전 ----");
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("--- 스프링 컨테이너 구동후 ----");
		UserService userService = (UserService) container.getBean("userService");
		
		System.out.println("--- 유저정보 조회 ---");
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test999");
		System.out.println("찾을 유저 : " + vo);
		
		UserVO selectedUser = userService.getUser(vo);
		System.out.println("검색된 유저 : " + selectedUser);

		System.out.println("--- 스프링 컨테이너 종료(close) ----");
		container.close();
		
		
	}

}





