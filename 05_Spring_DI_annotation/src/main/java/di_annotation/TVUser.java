package di_annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		System.out.println("--- 스프링 컨테이너 구동전 ----");
		GenericXmlApplicationContext factory
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("--- 스프링 컨테이너 구동후 ----");
		
		
		System.out.println("--- tv 요청 사용 ----");
		TV tv = (TV) factory.getBean("SamsungTV");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		System.out.println("tv : " + tv);
		
		
		System.out.println("--- tv2 요청 사용 ----");
		TV tv2 = (TV) factory.getBean("lgTV");
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
		System.out.println("tv2 : " + tv2);

		System.out.println("--- 스프링 컨테이너 종료(close) ----");
		factory.close();
		
		
	}

}

