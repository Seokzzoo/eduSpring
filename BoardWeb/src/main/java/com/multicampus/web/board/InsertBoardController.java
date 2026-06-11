package com.multicampus.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;

@Controller
public class InsertBoardController {
	
//	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAOJdbc dao) throws Exception {
		dao.insertBoard(vo);
		// 문자열을 리턴하면 해당 화면으로 Forward된다.
		return "getBoardList.do";
	}

}
