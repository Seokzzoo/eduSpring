package com.multicampus.web;

import java.io.IOException;
import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardDAOJdbc;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserDAOJdbc;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DispatcherServlet extends HttpServlet {
	public DispatcherServlet() {
		System.out.println("===> DispatcherServlet 생성");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("---> init() 호출 : 멤버변수 초기화");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 path를 추출한다.
		String uri = request.getRequestURI();
//		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 요청 path에 따라 분기처리한다.
		if (path.equals("/login.do")) {
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
			if (user != null) {
				System.out.println("로그인 성공!");
				response.sendRedirect("getBoardList.do");
			} else {
				System.out.println("로그인 실패!");
				response.sendRedirect("login.jsp");
			}
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 로그아웃을 요청한 브라우저와 매핑된 세션을 강제 종료한다
			HttpSession session = request.getSession();
			session.invalidate();
			
			// 메인 페이지(index.jsp)로 이동한다.
			response.sendRedirect("/");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			// 1. 사용자 입력정보(title, writer, content) 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAOJdbc();
			dao.insertBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			// 1. 사용자 입력정보(title, seq, content) 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAOJdbc();
			dao.updateBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do"); // 세션 refresh
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			// 1. 사용자 입력정보(seq) 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAOJdbc();
			dao.deleteBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAOJdbc();
			BoardVO board = dao.getBoard(vo);
			
			// 3. 검색 결과를 JSP에서 사용할 수 있도록 세션에 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			// 4. 화면 이동
			response.sendRedirect("getBoard.jsp");
			
		} else if (path.equals("/getBoardList.do")) {
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
			response.sendRedirect("getBoardList.jsp");
		} else {
			System.out.println("요청 URL을 확인하세요.");
		}
	}
}
