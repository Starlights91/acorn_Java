package test.box;

import test.fruit.Banana;

public class BananaBox {
	// 필드
	private Banana item;
	
	// 바나나를 포장하는 메소드
	public void pack(Banana item) {
		this.item=item;
	}
	
	// 바나나를 꺼내는 메소드
	public Banana unPack() {
		return item;
	}
}
	
