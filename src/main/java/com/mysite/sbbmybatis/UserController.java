package com.mysite.sbbmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 페이지
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	// 상세정보 /user/hong
	@GetMapping("/user/{username}")
	public String getUser(@PathVariable("username") String username, Model model) {
		User user = userService.getUser(username);
		model.addAttribute("user", user);
		return "/user/detail";
	}
}
