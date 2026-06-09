package com.multicampus.biz;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. Spring 컨테이너로부터 비즈니스 컴포넌트를 Lookup한다. 
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 비즈니스 컴포넌트를 사용한다. 
		// 글 등록
		BoardVO vo = new BoardVO();
		vo.setSeq(999);
		vo.setTitle("Spring 테스트");
		vo.setWriter("테스터");
		vo.setContent("Spring 테스트 중입니다.");
		boardService.insertBoard(vo);
		
//		// 글 목록 검색
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		for (BoardVO board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//		
//		// 글 삭제
//		vo.setSeq(4);
//		boardService.deleteBoard(vo);
		
		// 4. Spring 컨테이너를 종료한다.
		container.close();
	}

}
