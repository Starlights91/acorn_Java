package test.mypac;

/*
 *  이미 존재하는 Phone 클래스를 extends(상속) 받아서 HandPhone 클래스 정의하기
 *  - Phone 클래스가 동일한 패키지에 있기 때문에 import 필요 없음
 */
public class HandPhone extends Phone{
	// 생성자
	public HandPhone() {
		System.out.println("HandPhone 생성자 호출됨");
	}
	
	// 이동중에 전화를 걸어요
	public void mobileCall() {
		System.out.println("이동중에 전화를 걸어요");
	}
	
	// 사진 찍는 메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
	
	/*
	 * HandPhone p1=new HandPhone();
	 * p1.mobileCall();
	 * p1.takePicture();
	 * p1.call(); : Phone 클래스를 상속받았기 때문에 사용 가능하다
	 */
}

