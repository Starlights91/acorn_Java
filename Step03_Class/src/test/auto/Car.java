package test.auto;
/*
 * class 의 역할
 * 1. 객체의 설계도 역할
 * 	 - 객체는 heap 영역(사물함)에 들어있는 물건이라고 생각하면 된다.
 *   - class를 이용해서 객체를 원하는 시점에 원하는 갯수 만큼 만들어 낼 수 있다.
 *   - 만들어진 객체가 어떤 저장소와 어떤 기능을 가지게 할지 class로 설계할 수 있다.
 *   
 * 2. data type 역할
 * 
 * 3. static 필드와 메소드를 포함하는 역할
 */
public class Car {
	// 차의 이름을 저장할 필드 만들기 (필드는 지역 변수가 아님, 객체 고유의 저장소이다)
	public String name; // 참조데이터 type의 기본값은 null
	// 차의 가격을 저장할 필드 만들기
	public int price;   // 기본데이터(int) type의 기본값을 0
	
	// 달리는 기능(method) 만들기
	public void drive() {
		System.out.println(this.name+"이(가) 부릉부릉 하고 있어요");
		// 클래스를 설계하는 시점에 this는 값을 알 수 없다.
	}
}
