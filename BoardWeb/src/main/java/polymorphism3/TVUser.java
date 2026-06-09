package polymorphism3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 1. 클래스 패스 상에 존재하는 XML 파일을 읽어서 Spring 컨테이너를 생성한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 사용할 객체를 검색(Lookup)한다.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();		
		tv.powerOff();
		
		// 3. Spring 컨테이너를 종료하면 컨테이너가 관리하던 모든 객체가 삭제된다.
		container.close();
	}
}
