package polymorphism3;

import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		// 1. 클래스 패스 상에 존재하는 XML 파일을 읽어서 Spring 컨테이너를 생성한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 사용할 객체를 검색(Lookup)한다.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		Properties memberList = bean.getMemberList();
		
		System.out.println("[ 주소 목록 ]");
		for (Object address : memberList.values()) {
			System.out.println("---> " + address.toString());
		}
		
		System.out.println("[ 이름 목록 ]");
		for (Object name : memberList.keySet()) {
			System.out.println("---> " + name.toString());
		}
		
		// 3. Spring 컨테이너를 종료하면 컨테이너가 관리하던 모든 객체가 삭제된다.
		container.close();
	}
}
