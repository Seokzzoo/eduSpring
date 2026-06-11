package com.multicampus.web.user;

import org.springframework.web.servlet.ModelAndView;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserDAOJdbc;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginController {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력정보(id, password) 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAOJdbc();
		UserVO user = dao.getUser(vo);
		
		// 3. 화면 이동
		ModelAndView mav = new ModelAndView();
		String view = "login.jsp";
		
		if(user != null) {
			view = "getBoardList.do";
		}
		
		mav.setViewName(view);
		return mav;
	}

}
