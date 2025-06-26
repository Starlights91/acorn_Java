package test.mypac;

//공중 공격을 담당하는 무기을 만든다고 가정
public class SkyWeapon extends Weapon {
	/*
	 * 	Weapon 객체(추상클래스 로 생성된 객체)가 제공해주는 기능을 활용하면서
	 * 	attack() 나의 상황(용도, 프로젝트 요구사항)에 맞게 구현할수 있다.
	 */
	
	@Override
	public void attack() {
		//부모객체가 제공해주는 기능도 사용가능! // this. 생략 가능.
		this.prepare();
		System.out.println("공중 공격을 해요!");
		
		
	}
}
