package kr.co.jgm.user.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.jgm.user.domain.User;

public interface UserStore {

	public User selectUserLogin(SqlSession session, User user);

	public int insertUser(SqlSession session, User user);
	
	public int updateUser(SqlSession session, User user);

	public int deleteUser(SqlSession session, String userId);

	public User selectOneById(SqlSession session, String userId);

}
