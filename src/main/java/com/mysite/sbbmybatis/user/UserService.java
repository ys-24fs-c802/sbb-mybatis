package com.mysite.sbbmybatis.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	// 의존성 주입 @Autowired를 사용
	// UserMapper userMapper = new UserMapper();
	
	public void addUser(User user) {
		//String username = user.getUsername();
		//String psw = user.getPsw();
		String salt = BCrypt.gensalt();
		String encPsw = BCrypt.hashpw(user.getPsw(), salt);
		user.setPsw(encPsw);
		
		userMapper.addUser(user);
	}
	
	public User getUser(User user) {
		return userMapper.getUserByUsername(user.getUsername());
	}
	
	public boolean checkUser(User user) {
		// TODO null값 예외처리
		// 사용자 확인
		User member = getUser(user);
		// 비밀번호 확인
		return BCrypt.checkpw(user.getPsw(), member.getPsw());
	}

}
