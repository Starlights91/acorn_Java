package test.main;

import test.mypac.Weapon;
import test.mypac.MyWeapon;
import test.mypac.SeaWeapon;
import test.mypac.SkyWeapon;

// prepare() 는 부모(Weapon)이 하고, 나머지 자식들은 공격에만 집중할 수 있다.
public class MainClass02 {
	public static void main(String[] args) {
		//공중 공격을 하는 Weapon type 객체
		Weapon w1=new SkyWeapon(); // 하위 클래스에서 객체 생성한?
		w1.attack();
		//지상 공격을 하는 Weapon type 객체
		Weapon w2=new MyWeapon(); // 
		w2.attack();
		
		/*
		 * 해상 공격(seaWeapon)을 하는 Weapon type 객체를 만들어서 .attack() 메소드를 호출했을때 해상공격이 되도록 구현해 보세요.
		 * 
		 * 단) 기존에 만든 SkyWeapon, MyWeapon, Weapon 클래스를 수정하지 마세요
		 * 	새로운 클래스를 만들어서 구현하세요.
		 * 
		 * 클래스 하나 만들고 2줄 코딩 아래에 하면 됨.
		 */
		Weapon w3=new SeaWeapon(); // seaWeapon
		w3.attack();
	
	}

}
