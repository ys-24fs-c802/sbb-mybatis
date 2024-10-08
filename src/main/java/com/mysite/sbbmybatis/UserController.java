package com.mysite.sbbmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 로그인 페이지
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	// 상세정보 /user/hong
	@GetMapping("/user/{username}")
	@ResponseBody
	public User getUser(@PathVariable("username") String username) {
		// String username = "hong";
		// 사용자 아이디에 맞는 정보를 가져온다. --- 서비스
		return userService.getUser(username);
	}
}
