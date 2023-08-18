package kr.co.jgm.user.service.impl;

import org.springframework.stereotype.Service;

import kr.co.jgm.user.domain.User;
import kr.co.jgm.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Override
	public User selectCheckLogin(User user) {
		return user;
	}

}
