package test.main;

import test.box.FruitBox;
import test.fruit.Apple;
import test.fruit.Banana;

public class MainClass02 {
	public static void main(String[] args) {
		
		// < > 이 Generic 클래스 안에 담는것에 따라 담아지는게 달라짐
		// Apple 을 담을 용도로 사용할 FruitBox 객체 생성하기
		FruitBox<Apple> box1 = new FruitBox<Apple>();
		box1.pack(new Apple());

		// Banana 을 담을 용도로 사용할 FruitBox 객체 생성하기
		FruitBox<Banana> box2 = new FruitBox<Banana>();
		box2.pack(new Banana());
		
	}

}
