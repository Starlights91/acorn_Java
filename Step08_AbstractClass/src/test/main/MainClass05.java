package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * - 우주를 공격하고 싶다
		 * - Weapon 추상 클래스를 상속받은 클래스를 파일로 만들어야 하는 졸라 구찮음 OTL
		 * - Local Inner Class 로 만들면 좀 편하것다~~
		 */
		class SpaceWeapon extends Weapon{ 
			// 위의 SpaceWeapon 마우스 올리면: add unimplemented method 아직 구현되지 않은 메소드 추가 하겠단 뜻.
			// 아래에 오버라이드 생성

			@Override
			public void attack() {
				prepare();
				System.out.println("우주를 공격해요");
			} 
			
		}
		//위에서 생성한 클래스로 객체를 생성
		Weapon w1=new SpaceWeapon();
		//메소드 호출
		w1.attack(); // 이 메소드는 여러번사용 가능. 근데 이 메소드는 한번만 호출하면 되는데, 굳이 w1 이라는 지역변수를 만들어야 할까?
		
		//Weapon type 변수를 만들기도 졸라 구찮아
		//(나) new SpaceWeapon() => Weapon type 의 참조값이 나온다.
		//(나) attack();
		new SpaceWeapon().attack(); // [기억하기]  객체를 생성해서 1회용으로 사용하는 것도 가능하다!
		//int ranNum = new Random().netInt(); // [이런 모양 기억하기] 객체를 1회용으로 사용. //new Random() = random type & .netInt() = int type.
		
		//정리: SpaceWeapon 이 Weapon 추상 클래스 타입을 가져와서 SpaceWeapon();
		
	}

}
