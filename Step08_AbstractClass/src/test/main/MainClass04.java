package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * - 메소드 안에 클래스도 정의 할수 있다.
		 * - 메소드 안에서만 사용할수 있다.
		 * - 지역 내부클래스(Local Inner Class) 라고 한다.
		 */
		class Cat{
			public void say() {
				System.out.println("야옹~");
			}
		}
		// Local Inner Class 로 객체도 생성 가능하다
		Cat c1=new Cat();
		c1.say();
	}

}
