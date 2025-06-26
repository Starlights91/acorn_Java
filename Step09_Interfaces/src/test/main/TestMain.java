// 이 클래스가 속해 있는 패키지 명시하기 (없으면 에러)
package test.main;
// 클래스 안에서 사용하는 다른 클래스나 인터페이스 import

public class TestMain { // 클래스의 범위를 나타내는 중괄호 "시작"
	/*
	 * 	클래스안에 무언가를 정의 할때는 클래스 안에 속해 있다는 의미에서 들여 쓰기를 한다
	 * 	클래스 안에 정의할수 있는것은: 
	 * 	1. 필드, static 필드
	 * 	2. 메소드, static 메소드
	 * 	3. 생성자 
	 * 	4. 또다른 클래스(Inner Class)
	 * 	5. 순서가 정해진것은 아니지만 보통
	 * 	   필드 => 생성자 => 메소드 순으로 정의한다. 
	 */
	
	//
	//필드
	public String name = "김구라"; // 얘 소속은 TestMain 클래스 안에 소속되어 있다.
	//static 필드
	public static String yourName="해골"; // 얘 소속도 TestMain 클래스 안에 소속되어 있다.
	
	//생성자 (메소드와 닮아 있지만 return type 이 없고 클래스명과 동일해야 한다)
	// 생성자는 순서대로 위에서부터 아래로 실행된다.
	public TestMain() { // {} 여기 중괄호는 생성자 범위, 생성자는 위에서 부터 실행된다.
		// 여기는 생성자 내부 (생성자 내부라는 의미에서 들여쓰기를 한다)
		// 어디에선가 new TestMain() 해서 객체를 생성하면 여기가 실행된다.
		System.out.println("TestMain 생성자가 호출됨");
		// 생성자 안에는 지역변수를 만들수 있다.

	}
	
	//메소드 (메소드 안에 메소드 작성은 불가!)
	// (나) 하단엔 static 이 없기 때문에 new TestMain().test(); 객체를 만들어 주어야 한다.
	public void test() {
		// 여기는 메소드 내부 (메소드 내부라는 의미에서 들여쓰기를 한다)
		// 어디에선가 이 클래스(TestMain) 으로 생성된 객체의 test() 메소드를 호출하면 여기가 실행된다.
		System.out.println("test() 메소드 호출됨");
		// 메소드 안에는 지역변수를 만들수 있다. (메소드는 만들수 없음)
	}
	
	//static 메소드
	public static void doSomething() {
		//어디에선가 클래스명에 . 찍어서 호출하는 메소드 TestMain.doSomething() 으로 호출할수 있다.
		System.out.println("doSomething() 메소드 호출됨");
	}
	
	// run 했을때(application 을 실행) 실행의 흐름이 시작되는 아주 특별한 main 메소드
	// (나) JavaScript 의 스크립트 부분과 같이 실행 준비되어 있는 곳
	public static void main(String[] args) {
		//application 의 동작을 여기서 준비한다. (지금은 단순히 학습을 위해 이상한 뻘짓만 하고 있지만...)
		//객체 생성이나, 반복문, 메소드 호출 등등을 여기서 연습을 우리는 하고 있는중...
	
		
	}

	
} // 클래스의 범위를 나타내는 중괄호 "끝"







