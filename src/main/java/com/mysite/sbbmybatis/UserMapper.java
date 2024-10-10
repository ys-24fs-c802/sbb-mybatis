package com.mysite.sbbmybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	User getUserByUsername(String username);
	User getUserPswByUsername(String username);
	// 회원가입
	void signup(User user);

}
