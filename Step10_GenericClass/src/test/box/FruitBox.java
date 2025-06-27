package test.box;

// Generic 클래스 T 를 (포괄클래스, 아무거나 전달받을수 있는 클래스) 전달 받을수 있는 클래스 설계하기
//<T> = type 이라는 의미. 안의 알파벳은 다른거 사용 가능.
public class FruitBox<T> { //FruitBox<Apple>
	// T 를 필드의 type 으로 활용
	private T item;
	
	// T 를 매개변수의 type 으로 활용
	public void pack(T item) {
		this.item=item;
	}
	
	// T 를 메소드의 리턴 type 으로 활용
	public T unPack() {
		return item;
	}

}
