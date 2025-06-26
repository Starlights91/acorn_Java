package test.main;

import test.mypac.Weapon;
import test.mypac.MyWeapon;

public class MainClass01 {
	public static void main(String[] args) {
		//추상 클래스도 data type 의 역할을 할수가 있다.
		Weapon w1 = null;
		//w1.
		
		//그렇다면 Weapon type 의 참조값은 어떻게 얻어내기?
		//Weapon w2 = new Weapon(); //단독 객체 생성은 불가하다.
		
		Weapon w2 = new MyWeapon();
		w2.prepare();
		w2.attack();
	}
}
