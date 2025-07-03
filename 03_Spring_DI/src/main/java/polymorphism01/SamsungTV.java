package polymorphism01;

public class SamsungTV implements TV {
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV() 실행~");
		// 직접 필드에 SonySpeaker 타입 객체 주입(저장)
		speaker = new SonySpeaker();
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF~~");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV - 소리크게");
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
		speaker.volumeDown();
	}
	
	//------------
	public void initMethod() {
		System.out.println("> SamsungTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println("> SamsungTV - destroyMethod() 실행");
	}
	
	
}









