package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 	- Cyber 공간을 공격하고 싶다
		 * 	- 클래스 파일을 따로 만들기 싫다 => Local Inner Class 로 만들면된다.
		 * 	- 근데 생각해보면 MyWeapon, SkyWeapon, SeaWeapon, SpaceWeapon 등의 type 은 
		 * 	  필요 없다. 따라서 클래스의 이름을 짓기도 귀찮다면? => 익명의 Local Inner Class 를 활용!
		 */
		// 이름이 없는 익명의 Local Inner Class
		// 하단 부분[Day23]
		Weapon w1 = new Weapon() { // 여기 new 뒤의 Weapon 입력하고 ctrl+space => 하단의 @Override 자동입력완성 가능.
			@Override
			public void attack() {
				prepare(); // => 무기 작동을 준비 합니다.
				System.out.println("Cyber 공격을 해요");
			}
		}; // new Weapon() { 부터 ~ 여기까진 Weapon type 의 참조값이 이위치에 리턴된다.
		w1.attack(); // Cyber 공격이 되면 된다.
		
		/*
		 * 	가상(virtual) 공간을 공격해야 한다.
		 * 	익명의 Local Inner Class 를 이용해서 Weapon type 객체를 생성해서 공격할 예정인데
		 * 	1번만 공격할꺼야 => 위에처럼 w1 이라는 변수를 만들지 않고 1회용으로 객체를 만들어서 사용할 예정
		 *  MainClass05 처럼 Weapon.attack(); 
		 */
		
		// 아래 만드는 법: 
		// new Weapon => ctrl+space => Anonymous Inner Type 불러오면, 하단에 @Override 자동 생성.
		new Weapon() {
			
			@Override
			public void attack() {
				prepare(); // => 무기 작동을 준비 합니다.
				System.out.println("Virtual 공간을 공격해요!");
			}
		}.attack(); // 여기까지가 @Override 자동 생성이 되는데, }; => 세미콜론 지우고 . 점찍고 .attack(); 해서, 아까 MainClass05 객체를 생성해서 1회용으로 사용하는 것 처럼 사용 가능.
	}

}
 
