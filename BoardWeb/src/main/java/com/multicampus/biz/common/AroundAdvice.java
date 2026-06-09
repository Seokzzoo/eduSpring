package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	// Aournd 메소드는 리턴타입(Object)과 매개변수(ProceedingJoinPoint)가 고정된다.
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		// 클라이언트가 호출한 메소드 이름을 추출한다.
		String method = jp.getSignature().getName();
		Object returnObj = null;
		
		StopWatch watch = new StopWatch();
		watch.start();
		
		// jp.proceed() 메소드가 호출되는 순간 비즈니스 메소드가 실행된다.
		returnObj = jp.proceed();
		
		watch.stop();
		System.out.println(method + "() 메소드 수행 시간 : " + watch.getTotalTimeMillis());
		return returnObj;
	}
}
