package com.multicampus.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	// After-Returning은 비즈니스 메소드가 리턴한 데이터를 받아서 사후처리 로직을 작성할 수 있다. 
	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning = "returnObj")
	public void afterLog(Object returnObj) {

		System.out.println("[사후 처리] 비즈니스 메소드 리턴 값 : " + returnObj.toString());
		
		// 비즈니스 메소드(getUser())가 UserVO 객체를 리턴했는지 확인
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			// UserVO 객체의 권한(role)이 ADMIN인지 확인
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "님! 관리자 전용 페이지로 이동하세요.");
			}
		}
	}
}
