package polymorphism3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	// Type Injection
	// 1. Speaker 타입의 객체를 찾아서 speaker 변수에 할당해라.
	// 2. Speaker 타입의 객체는 반드시 유일해야 한다.
	@Autowired
	//@Qualifier("appleSpeaker")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 생성");
	}
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
