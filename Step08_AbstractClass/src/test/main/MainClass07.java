package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass07 {
	public static void main(String[] args) { // [ 함수 호출 장소 ] main 메소드 안쪽 => 대부분의 함수 호출은 여기처럼 항상 윗부에 올라가서!!
		
		/*
		 * 여기서(main 메소드 안쪽) 아래에 정의된 useWeapon() 메소드를 호출하려면?
		 */
		
		//MainClass07.useWeapon(
		
		Weapon w1 = new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("attack anywhere");
			}
		};
		useWeapon(w1);
		
		//=>
		
		
		
		useWeapon(new Weapon() {
		// Anonymous class 익명클래스 사용하기
			@Override
			public void attack() {
				
				prepare();
				System.out.println("---");
			}
		});
		
		useNum(12);
		useString("이");
		
	} // 여기 {} 에서 호출해야함!! 
			
			
	public static void useWeapon(Weapon w) {
		w.attack();
		
	}
	
	public static void useNum(int num) {
	
	}
	
	public static void useString(String name) {
	}


}
