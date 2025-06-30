package test.main;

import test.mypac.MyFunction;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * MyFunction 인터페이스는
		 * execute() 추상메소드 1개, log() default 메소드 1개, help() static 메소드 1개를 가지고 있다.
		 */
		// MyFunction f1 = () -> {};
		MyFunction f1 = () -> {
			System.out.println("실행합니다");
		};
		//구현 메소드 호출
		f1.execute();
		//default 메소드 호출 // 인터페이스 타입의 (default 메소드는) 기본 메소드 = 일반 클래스의 기본인 Object 타입 같은
		f1.log(); // f1.log => D= default 호출
		//static 메소드 호출
		MyFunction.help(); // static 이기때문에 인터페이스 1개당 1개. 
		
		System.out.println(); // static
		
		
	}

}
