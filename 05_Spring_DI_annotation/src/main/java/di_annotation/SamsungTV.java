package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component : 객체 생성, 명칭 생략시 타입 첫글자 소문자인 명칭 사용
@Component("SamsungTV")
public class SamsungTV implements TV {
	// 필드에 @Autowired, @Qualifier 어노테이션 설정
	//@Autowired // 동일한 데이터 타입을 찾아서 주입
	//@Qualifier("apple")
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV() 실행~");
	}
	
/*	
	//생성자에 @Autowired 설정하고, 파라미터에 @Qualifier 설정
	@Autowired
	public SamsungTV(@Qualifier("sony") Speaker speaker) {
		System.out.println(">> SamsungTV(speaker) 실행~");
		this.speaker = speaker;
	}
*/
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 실행~");
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(AppleSpeaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker, width, height) 실행~");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
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
	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}

	//==== setter, getter =====
	public Speaker getSpeaker() {
		return speaker;
	}

	@Autowired
	@Qualifier("apple")
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("---> apple setSpeaker(speaker) 실행~~");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}









