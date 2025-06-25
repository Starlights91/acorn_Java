package test.main;

import test.auto.Car;

public class MainClass02 {
	public static void main(String[] args) {
		// Car type 객체의 참조값(id)를 담을 수 있는 c1 이라는 이름의 비어있는 변수 만들기
		Car c1 = null;
		// Car 클래스로 객체를 생성하고 할당 된 참조값을 c1에 대입하기
		c1 = new Car();
		// c1에 들어있는 참조값을 이용해서 drive() 메소드 호출하기
		c1.drive();
		
		// Car 클래스로 객체를 하나 더 생성하고 할당 된 참조값을 c2에 대입하기
		Car c2 = new Car();
		// c2에 들어있는 참조값을 이용해서 drive() 메소드 호출
		c2.drive();
		
		System.out.println("main 메소드가 종료 됩니다");
	}
}
