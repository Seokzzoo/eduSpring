package com.multicampus.web.board;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetBoardListController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 검색 처리");
		
		// 1. 사용자 입력정보 추출
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAOJdbc();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 3. 검색 결과를 JSP에서 사용할 수 있도록 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		// 4. 화면 이동
		//response.sendRedirect("getBoardList.jsp"); 화면이동 하지 않는다
		
		// ModelAndView에 이동할 화면을 설정하여 리턴하면 해당 화면으로 자동 Forward된다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp"); // jsp로 포워드
		return mav;
	}

}
