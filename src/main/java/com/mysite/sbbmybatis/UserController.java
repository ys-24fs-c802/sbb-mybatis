package com.mysite.sbbmybatis;

import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private boolean checkPsw(String userPsw, String memberPsw) {
		return BCrypt.checkpw(userPsw, memberPsw);
//		return psw1.equals(psw2);
	}
	
	// 로그인 페이지
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<?> login2(@RequestBody User user) {
		User member = userService.getUserPsw(user.getUsername());
		if (member != null) {
			if (checkPsw(user.getPsw(), member.getPsw())) {
				// 로그인 성공
				return ResponseEntity.ok().body(Map.of("message", "로그인 성공", "user", member));
			} else {
				// 로그인 실패
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "비밀번호가 일치하지 않습니다."));
			}
		} else {
			// 사용자를 찾을 수 없습니다.
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "사용자를 찾을 수 없습니다."));
		}
	}
	
	// 상세정보 /user/hong
	@GetMapping("/user/{username}")
	public String getUser(@PathVariable("username") String username, Model model) {
		User user = userService.getUser(username);
		if (user != null) {
			model.addAttribute("user", user);
			return "/user/detail";
		} else {
			model.addAttribute("message", "사용자를 찾을 수 없습니다.");
			return "/user/user-not-found";
		}
	}
	
	// 회원가입 페이지
	@GetMapping("/user/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "user/signup";
	}
	
	// 회원가입 처리
	@PostMapping("/user/signup")
	public String signup2(@ModelAttribute("user") User user,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) { return "signup"; }
			
		try {
			userService.signup(user);
			redirectAttributes.addFlashAttribute("message", "회원가입을 축하합니다.");
			return "redirect:/";
		} catch (Exception e) {
			result.rejectValue("username", "error.user", e.getMessage());
			return "/user/signup";
		}
	}
	
}
