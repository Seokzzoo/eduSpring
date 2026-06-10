package com.multicampus.biz.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	// 회원 상세 조회
	UserVO getUser(UserVO vo);

}