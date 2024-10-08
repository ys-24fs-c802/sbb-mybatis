package com.mysite.sbbmybatis;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public User getUser(String username) {
		User user1 = new User();
		user1.setId(1);
		user1.setUsername(username);
		user1.setPsw("1234");
		LocalDateTime now = LocalDateTime.now();
		user1.setCreatedAt(now);
		user1.setUpdatedAt(now);
		
		return user1;
	}

}
