package com.multicampus.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class GetBoardController {
	
//	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAOJdbc dao, HttpSession session) throws Exception {
		System.out.println("글 상세 조회 처리");
		
		// 1. 사용자 입력정보 추출
//		String seq = request.getParameter("seq");
//		
//		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO dao = new BoardDAOJdbc();
//		BoardVO board = dao.getBoard(vo);
//			
//		// 3. 검색 결과를 JSP에서 사용할 수 있도록 세션에 등록한다.
//		HttpSession session = request.getSession();
		
		// 4. 화면 이동
		// ModelAndView에 이동할 화면을 설정하여 리턴하면 해당 화면으로 자동 Forward된다.
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoard.jsp");
//		return mav;
		session.setAttribute("board", dao.getBoard(vo));
		return "getBoard.jsp";
	}

}
