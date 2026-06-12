package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class UserDAOIbatis implements UserDAO {
	// iBATIS 컨테이너(SqlMapClientTemplate)를 공장으로부터 획득하는 Template을 주입한다
	@Autowired
	private SqlMapClientTemplate ibatis;

	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> iBATIS 기반으로 getUser() 기능 처리");
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}
}
