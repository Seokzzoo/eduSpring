package com.multicampus.biz.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class BoardDAOIbatis implements BoardDAO {
	// JDBC 관련 변수 선언
//	private Connection conn = null;
//	private PreparedStatement stmt = null;
//	private ResultSet rs = null;
	// iBATIS 컨테이너(SqlMapClientTemplate)를 공장으로부터 획득하는 Template을 주입한다
	@Autowired
	private SqlMapClientTemplate ibatis;

	// BOARD 테이블 관련 SQL 명령어들
//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?,?,?,?)"; // tx test
//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
//	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
//	private final String BOARD_DELETE = "delete board where seq=?";
//	private final String BOARD_GET    = "select * from board where seq=?";
//	private final String BOARD_LIST   = "select * from board order by seq desc";
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 insertBoard() 기능 처리");
		ibatis.update("insertBoard", vo);
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 updateBoard() 기능 처리");
		ibatis.update("updateBoard", vo);
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 deleteBoard() 기능 처리");
		ibatis.update("deleteBoard", vo);
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 getBoard() 기능 처리");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}

	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 getBoard() 기능 처리");
		return ibatis.queryForList("getBoardList", vo);
	}
}
