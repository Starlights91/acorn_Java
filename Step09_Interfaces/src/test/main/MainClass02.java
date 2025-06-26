package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		//다형성 확인
		Object r1=new MyRemocon(); // x 사용설명서만 object
		Remocon r2=new MyRemocon(); // O
		MyRemocon r3=new MyRemocon(); // O
		
		// 아래의 메소드 호출하는 연습
		useRemocon(r2); 
		useRemocon(r3); 
		// useRemocon(r1); // r1은 Object type 이기 때문에 casting 해야 호출할 수 있다.
		useRemocon((Remocon)r1);
		
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}

}
