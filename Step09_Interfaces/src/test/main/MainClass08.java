package test.main;

import test.mypac.Programmer;
import test.mypac.Singer;

// 다형성: 하나의 객체는 다양한 타입일 수 있다(상속관계에 따라서, 구현 관계에 따라서). 따라서, 원하는 타입으로만 받아서 사용.
public class MainClass08 {
	public static void main(String[] args) {
		// Person 객체를 생성해서 Person type 으로 받으면 모든 메소드를 다 사용할수 있다.
		Person p1 = new Person();
		p1.work();
		p1.sing();
		p1.develop();
		
		System.out.println("----------------");
		// Person 객체를 생성해서 Singer type 으로 받으면 sing() 메소드만 사용가능
		Singer p2 = new Person();
		p2.sing();
		
		System.out.println("----------------");
		// Person 객체를 생성해서 Programmer type 으로 받으면 develop() 메소드만 사용가능
		Programmer p3 = new Person();
		p3.develop();
	}

}
