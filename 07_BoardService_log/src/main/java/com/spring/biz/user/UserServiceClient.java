package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


public class UserServiceClient {

	public static void main(String[] args) {
		System.out.println(" [UserServiceClient] >> 스프링 컨테이너 구동 전");
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println(" [UserServiceClient] >> 스프링 컨테이너 구동 후");
		UserService userService = (UserService) container.getBean("userService");
	
		// INSERT
		UserVO vo = new UserVO();
		vo.setId("user3");
		vo.setPassword("user3");
		vo.setName("을지문덕");
		vo.setRole("User");
		
		userService.insertUser(vo);

		
		
		
		
		
		
		
		System.out.println(" [UserServiceClient] >> 스프링 컨테이너 종료 (close)");
		container.close();
		
		
	}

}