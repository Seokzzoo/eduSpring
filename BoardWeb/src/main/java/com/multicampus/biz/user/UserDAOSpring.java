package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//@Repository
public class UserDAOSpring implements UserDAO {
//	private Connection conn;
//	private PreparedStatement stmt;
//	private ResultSet rs;
	
	@Autowired
	private JdbcTemplate spring;
	
	private static final String USER_GET = "select * from users where id=? and password=?";
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 getUser() 기능 처리");
		Object[] params = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, new UserRowMapper(), params);
	}
}
