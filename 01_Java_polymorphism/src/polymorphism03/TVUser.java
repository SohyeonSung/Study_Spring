package polymorphism03;

import java.util.Arrays;

class TVUser {

	public static void main(String[] args) {
		System.out.println("args : " + Arrays.toString(args));
		
		BeanFactory factory = new BeanFactory();
		
		// SamsungTV 사용 또는 LgTV 사용
		//TV tv = (TV) factory.getBean("samsung");
		
		TV tv = (TV) factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
