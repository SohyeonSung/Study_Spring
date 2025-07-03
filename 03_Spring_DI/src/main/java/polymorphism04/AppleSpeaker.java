package polymorphism04;

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("--->> AppleSpeaker() 실행");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("---AppleSpeaker - 소리크게");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("---AppleSpeaker - 소리작게~~");
	}

}
