package com.multicampus.web.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그아웃 처리");
		
		// 로그아웃을 요청한 브라우저와 매핑된 세션을 강제 종료한다. 
		HttpSession session = request.getSession();
		session.invalidate();

		// 메인 페이지(index.jsp)로 이동한다.		
		// ModelAndView에 이동할 화면을 설정하여 리턴하면 해당 화면으로 자동 Forward된다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/");
		return mav;
	}

}
