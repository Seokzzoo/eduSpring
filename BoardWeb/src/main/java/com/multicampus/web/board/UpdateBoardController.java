package com.multicampus.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

@Controller
public class UpdateBoardController {
	
//	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOJdbc dao) throws Exception {
//		System.out.println("글 수정 처리");
//		
//		// 1. 사용자 입력정보(title, seq, content) 추출
//		String title = request.getParameter("title");
//		String seq = request.getParameter("seq");
//		String content = request.getParameter("content");
//		
//		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setSeq(Integer.parseInt(seq));
//		vo.setContent(content);
//		
//		BoardDAO dao = new BoardDAOJdbc();
		dao.updateBoard(vo);
		
		// ModelAndView에 이동할 화면을 설정하여 리턴하면 해당 화면으로 자동 Forward된다.
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
//		return mav;
		return "getBoardList.do";
	}

}
