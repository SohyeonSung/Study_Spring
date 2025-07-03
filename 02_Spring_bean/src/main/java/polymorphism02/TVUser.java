package polymorphism02;

class TVUser {

	public static void main(String[] args) {
		// 삼성TV 사용
//		TV tv = new SamsungTV();
		
		// 엘지TV 사용
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		


	}

}
