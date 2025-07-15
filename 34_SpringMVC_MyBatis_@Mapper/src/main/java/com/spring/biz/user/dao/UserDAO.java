package com.spring.biz.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.spring.biz.user.UserVO;

// Mapper 인터페이스 사용방식으로 정의
@Mapper
public interface UserDAO {
	UserVO getUser(UserVO vo);
}






