package polymorphism04;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV() 실행~");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println(">> SamsungTV(speaker) 실행~");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 실행~");
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(SonySpeaker speaker, int width, int height) {
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

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("---> setSpeaker(speaker) 실행~~");
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









