package test.mypac;

//public class MyRemocon extends Object implements Remocon {  =>
//클래스는 단일 상속이라 한개의 부모만 가질 수 있다.
//인터페이스는 필요한 여러개를 구현 가능.
public class MyRemocon implements Remocon { //Remocon 마우스 오른쪽클릭'add unimplements...' 하면 

	@Override
	public void up() {
		System.out.println("볼륨을 올려요!");
				
	}

	@Override
	public void down() {
		System.out.println("볼륨을 내려요!");

	}

}
