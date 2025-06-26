package test.mypac;

// final 넣게 되면, 상속 못받음
public class SeaWeapon extends Weapon {

	@Override
	public void attack() {
		prepare(); // prepare(); 앞에 this. 생략되었음 
		System.out.println("해상 공격을 해요!");
		
	}
}
