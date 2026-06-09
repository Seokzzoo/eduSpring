package com.multicampus.biz;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. Spring 컨테이너로부터 비즈니스 컴포넌트를 Lookup한다. 
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. 비즈니스 컴포넌트를 사용한다. 
		UserVO vo = new UserVO();
		vo.setId("guest");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 로그인 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		// 4. Spring 컨테이너를 종료한다.
		container.close();
	}

}
