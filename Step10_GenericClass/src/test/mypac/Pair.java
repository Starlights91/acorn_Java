package test.mypac;

// Generic 클래스는 2개 이상일수도 있다.
// 실제론 내가 이 Generic클래스를 설계하는 것보단, MainClass03과 같은 클래스를 import 해서 사용할 일이 더 많다.
// K=key (String 타입) V= value (Object 타입)으로 설정된다. => MainClass03 에서 넣은 타입에(용도) 따라서 달라진다
public class Pair<K, V> {
	// 필드
	private K key;
	private V value;

	// 생성자
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	// 메소드
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}
