package test.main;

import test.fruit.Apple;
import test.mypac.Pair;

public class MainClass03 {
	public static void main(String[] args) {
		Pair<String, Object> p1 = null;
		Pair<Integer, String> p2 = null;
		// 기본 data type 은 Generic 클래스로 사용할수 없다.
		// Pair<int, String> p3=null; // => 8개 기본 타입에 참조데이터 타입으로 사용 가능 (byte -> Byte)
		// p2.getValue(); // => 에러 nullpointerExeption 난다!

		// 객체 생성시 Generic 클래스는 생략 가능 // 원래: 		Pair<String, Apple> p3 = new Pair<String, Apple>("my", new Apple());
		Pair<String, Apple> p3 = new Pair<>("my", new Apple());
		// 테스트로 메소드 사용해보기
		String a = p3.getKey();
		Apple b = p3.getValue();

	}
}
