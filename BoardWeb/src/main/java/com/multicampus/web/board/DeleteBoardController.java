package com.multicampus.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

@Controller
public class DeleteBoardController {
	
//	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOJdbc dao) throws Exception {
//		System.out.println("글 삭제 처리");
//		
//		// 1. 사용자 입력정보(seq) 추출
//		String seq = request.getParameter("seq");
//		
//		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO dao = new BoardDAOJdbc();
		dao.deleteBoard(vo);
		
		// ModelAndView에 이동할 화면을 설정하여 리턴하면 해당 화면으로 자동 Forward된다.
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
//		return mav;
		return "getBoardList.do";
	}

}
