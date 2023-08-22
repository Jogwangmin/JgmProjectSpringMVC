package kr.co.jgm.user.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.jgm.user.domain.User;
import kr.co.jgm.user.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{

	@Override
	public int insertUser(SqlSession session, User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}

	@Override
	public int updateUser(SqlSession session, User user) {
		int result = session.update("UserMapper.updateUser", user);
		return result;
	}
	@Override
	public int deleteUser(SqlSession session, String userId) {
		int result = session.delete("UserMapper.deleteUser", userId);
		return result;
	}
	@Override
	public User selectUserLogin(SqlSession session, User user) {
		User uOne = session.selectOne("UserMapper.selectUserLogin", user);
		return uOne;
	}

	@Override
	public User selectOneById(SqlSession session, String userId) {
		User user = session.selectOne("UserMapper.selectOneById", userId);
		return user;
	}
}
