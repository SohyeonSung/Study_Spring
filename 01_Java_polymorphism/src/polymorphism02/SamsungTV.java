package polymorphism02;

class SamsungTV implements TV {
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
