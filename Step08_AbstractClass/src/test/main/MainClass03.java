package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Monkey;
import test.mypac.Zoo.Tiger;

public class MainClass03 {
	public static void main(String[] args) {
		Zoo z1=new Zoo(); //Zoo 객체 z1 으로 생성
		
		// Zoo 객체의 getMonkey() 메소드를 호출해서 얻어낸 Monkey 객체의 say() 메소드 호출하기
		Monkey m1=z1.getMonkey();
		m1.say();
		
		// z1 에 들어 있는 참조값을 이용해서 Tiger 객체의 참조값을 얻어낸다음 roar() 메소드를 호출해 보세요
		Tiger t1=z1.getTiger(); // 이건 Tiger 임포트 해서 
		// 또는 Zoo.Tiger t1=z1.getTiger(); => 이렇게 사용 할 수도 있다.
		t1.roar();
	}

}
