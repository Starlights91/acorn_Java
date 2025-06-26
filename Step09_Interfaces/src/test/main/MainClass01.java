package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		// 인터페이스는 data type 의 역할도 할수 있다.
		Remocon r1=null;
		//r1. // up(); down();추상메소드 확인 가능.
		
		// 인터페이스 단독으로 객체 생성 불가 (아예 생성자 조차도 존재하지 않는다)
		//Remocon r2 = new Remocon();
		
		// 인터페이스 type 의 참조값이 필요하면 해당 인터페이스를 implements 한 하위 클래스를 이용해서 얻어낸다.
		Remocon r2 = new MyRemocon();
		r2.up();
		r2.down();
		
		// 인터페이스가 가지고 있는 상수 참조 (static final)
		String a = Remocon.COMPANY; // "LG"
		
	}

}
