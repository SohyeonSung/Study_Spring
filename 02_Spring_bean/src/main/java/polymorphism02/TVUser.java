package polymorphism02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		System.out.println("--- 스프링 컨테이너 구동전 ----");
		GenericXmlApplicationContext factory
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("--- 스프링 컨테이너 구동후 ----");
		
		System.out.println("--- tv 요청 사용 ----");
		TV tv = (TV) factory.getBean("tv2Lg");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		System.out.println("tv : " + tv);
		
		System.out.println("--- tv 요청(한번 더) ----");
		tv = (TV) factory.getBean("tv2Lg");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		System.out.println("tv : " + tv);

		System.out.println("--- 스프링 컨테이너 종료(close) ----");
		factory.close();
		
		
	}

}
