package com.spring.biz.user;


public interface UserService {
	
	
	// CURD 기능 구현 메소드 정의 
	void insertUser(UserVO vo);
	
	
	
	// 단일 목록 조회
	UserVO getUser(UserVO vo);


	

}
