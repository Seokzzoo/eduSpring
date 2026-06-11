package com.multicampus.web.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("board")
public class BoardController {

	// BoardService 타입의 객체(BoardServiceImpl)를 의존성 주입한다
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardListView.do")
	public String getBoardListView(BoardVO vo, HttpSession session) throws Exception {
		return "getBoardList";
	}
	
	@RequestMapping(value = {"/getBoardList.do", "/searchBoardList.do"})
	public String getBoardList(BoardVO vo, Model model ) throws Exception {
		// null check
		if (vo.getCondition() == null) vo.setCondition("title");
		if (vo.getKeyword() == null) vo.setKeyword("");
		
		// 검색 결과는 세션이 아닌 request에 등록해야 한다
		// Model에 등록된 데이터는 자동으로 request에 저장된다
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	// 글 등록 화면 이동
	@RequestMapping("/insertBoardView.do")
	public String insertBoardView(BoardVO vo) throws Exception {
		return "insertBoard";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		System.out.println("수정시 전달된 값 : " + vo.toString());
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
}