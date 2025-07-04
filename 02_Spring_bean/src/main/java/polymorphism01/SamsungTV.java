package polymorphism01;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println(">> SamsungTV() 실행~");
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
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게~~");
	}
}
