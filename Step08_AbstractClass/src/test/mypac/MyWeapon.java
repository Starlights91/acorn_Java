package test.mypac;

// 추상클래스(Weapon 부모클래스)를 상속받으면, 자식 클래스는부모의 추상 메소드를 "반드시 Override" 해야한다. (ctrl+space)
// myWeapon = 자식 , Weapon= 부모.
// 따라서, new myWeapon(); => 타입: Weapon, MyWeapon 둘다 가능. 
// 자식 클래스에서 재정의 & 객체 생성 Weapon w1=new myWeapon(); 
// w1.attack
public class MyWeapon extends Weapon {
	
	@Override
	public void attack() {
		System.out.println("지상 공격을 해요!");
		
	}

}
