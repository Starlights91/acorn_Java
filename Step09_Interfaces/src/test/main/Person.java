package test.main;

import test.mypac.Programmer;
import test.mypac.Singer;

//implements 뒤에 콤마 사용으로 여러개 사용 가능. & Person 위에 마우스 올려서 add unimplements... *2 => 
public class Person implements Singer, Programmer { //Person => 다 사용 가능, Singer=> sing 메소드만, Programmer=> develop 메소드만)
	public void work() {
		System.out.println("일을 해요!");
	}

	@Override
	public void sing() {
		System.out.println("노래를 불러요!");
		
	}

	@Override
	public void develop() {
		System.out.println("App 을 개발해요!");

	}

}
