package test.mypac;

// Weapon = 부모클래스 로 만듦
//클래스가 추상 메소드를 가지려면, abstract 넣어주면, 추상 메소드를 가질 수 있다 (추상메소드 = 미완성된 메소드)
//(나) 추상 메소드는 자식 클래스에서 반드시 구현해야함. (자식 클래스에서 상속받을 때 extends 사용)
public abstract class Weapon {
	//무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비 합니다.");
		
	}

	//공격하는 메소드
	// 접근지정자 추상메소드(예약어) 리턴값없음 
	public abstract void attack(); // Weapon w1=new Weapon(); 객체 생성 -> 참조값 w1.prepare(); 문법 성립 x 
  
}
