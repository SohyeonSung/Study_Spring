package com.spring.biz.user.impl;

import org.springframework.stereotype.Service;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;


@Service("userService")
public class UserServiceImpl implements UserService {
		private UserDAO userDAO;

		//@Autowired 설정하지 않아도 자동 주입(4.3 버전 이상)
	public UserServiceImpl(UserDAO userDAO) {
		System.out.println(" [UserServiceImpl] >> UserServiceImpl(UserDAO) 객체 생성");
		this.userDAO = userDAO;
	}	
	
	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
			
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
