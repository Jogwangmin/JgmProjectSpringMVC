package kr.co.jgm.user.service;

import kr.co.jgm.user.domain.User;

public interface UserService {
	
	/**
	 * 회원가입 Service
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * 회원 정보 수정 Service
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 * 회원 탈퇴 Service
	 * @param userId
	 * @return
	 */
	int deleteUser(String userId);

	/**
	 * 로그인 Service
	 * @param user
	 * @return
	 */
	User selectCheckLogin(User user);

	/**
	 * 회원 정보 조회 Service
	 * @param userId
	 * @return
	 */
	User getUserById(String userId);
}
