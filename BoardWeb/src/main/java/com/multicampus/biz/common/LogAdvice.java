package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
// 이 객체가 Aspect 객체임을 선언
@Aspect  // Aspect = Pointcut + Advice
public class LogAdvice {
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {
		// 클라이언트가 호출한 메소드 이름을 추출한다.
		String method = jp.getSignature().getName();
		
		// 비즈니스 메소드 호출할 때 전달한 인자 목록을 추출한다.
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method + "() 메소드 인자 정보 : " + 
		args[0].toString());
	}
}
