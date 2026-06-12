package com.multicampus.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAOJdbc;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// WEB-INF 폴더 하위에 있는 login.jsp 화면 호출을 위함
//	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do") // 버전업
	public String loginView(@ModelAttribute("user") UserVO vo) throws Exception {
//		System.out.println(9/0); // arithmetic error 발생
		System.out.println("---> loginView() 실행");
		// Command 객체에 값을 설정하면 JSP 파일에서 사용할 수 있다
		vo.setId("admin");
		vo.setPassword("test123");
		return "login";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
//	@PostMapping("./login.do") // 버전업
	public String login(UserVO vo) throws Exception {
		System.out.println("---> login() 실행");
		// 뷰이름 앞에 redirect:이나 forward:을 붙이면 ViewResolver가 동작하지 않는다
		if(userService.getUser(vo) != null) {
			return "forward:getBoardList.do";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(UserVO vo,  HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}