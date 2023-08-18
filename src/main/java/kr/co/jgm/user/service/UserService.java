package kr.co.jgm.user.service;

import kr.co.jgm.user.domain.User;

public interface UserService {

	User selectCheckLogin(User user);

}
