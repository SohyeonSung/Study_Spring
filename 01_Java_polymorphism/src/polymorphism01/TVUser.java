package polymorphism01;

class TVUser {

	public static void main(String[] args) {
		// 삼성TV 사용
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		// 엘지TV 사용
		LgTV tv = new LgTV();
		tv.on();
		tv.soundUp();
		tv.soundDown();
		tv.off();

	}

}
