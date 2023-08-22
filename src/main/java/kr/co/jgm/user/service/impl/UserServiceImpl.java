package kr.co.jgm.user.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jgm.user.domain.User;
import kr.co.jgm.user.service.UserService;
import kr.co.jgm.user.store.UserStore;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private UserStore uStore;
	
	@Override
	public int insertUser(User user) {
		int result = uStore.insertUser(session, user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = uStore.updateUser(session, user);
		return result;
	}

	@Override
	public int deleteUser(String userId) {
		int result = uStore.deleteUser(session, userId);
		return result;
	}

	@Override
	public User selectCheckLogin(User user) {
		User uOne = uStore.selectUserLogin(session, user);
		return uOne;
	}

	@Override
	public User getUserById(String userId) {
		User user = uStore.selectOneById(session, userId);
		return user;
	}
}
