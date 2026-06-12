package com.multicampus.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.multicampus.biz.common.SqlMapClientFactoryBean;

public interface BoardDAO {
//public class BoardDAO {
//	private SqlMapClient ibatis; 
//
//	public BoardDAO() {
//		ibatis = SqlMapClientFactoryBean.getSqlMapClientInstance();
//	}
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO vo);
//	public void insertBoard(BoardVO vo) throws SQLException {
//		System.out.println("===> iBatis기반으로 insertBoard() 기능 처리");
//		ibatis.insert("insertBoard",vo);
//	}

	// 글 수정
	void updateBoard(BoardVO vo);
//	public void updateBoard(BoardVO vo) throws SQLException {
//		System.out.println("===> iBatis기반으로 updateBoard() 기능 처리");
//		ibatis.update("updateBoard",vo);
//	}


	// 글 삭제
	void deleteBoard(BoardVO vo);
//	public void deleteBoard(BoardVO vo) throws SQLException {
//		System.out.println("===> iBatis기반으로 deleteBoard() 기능 처리");
//		ibatis.delete("deleteBoard",vo);
//	}


	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);
//	public BoardVO getBoard(BoardVO vo) throws SQLException {
//		System.out.println("===> iBatis기반으로 getBoard() 기능 처리");
//		return (BoardVO) ibatis.queryForObject("getBoard",vo);
//	}

	// 글 목록 검색
	List<BoardVO> getBoardList(BoardVO vo);
//	@SuppressWarnings("unchecked")
//	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
//		System.out.println("===> iBatis기반으로 getBoardList() 기능 처리");
//		return ibatis.queryForList("getBoardList",vo);
//	}
}