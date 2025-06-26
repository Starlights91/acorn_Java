package test.mypac;

public class Zoo {
	// 클래스 안에 정의 할 수 있는 것: [4가지]
	// 1.필드 2.메소드 3.생성자 4.또다른 클래스 정의 가능.
	
	//내부 클래스(Inner Class) 1
	public class Monkey{
		public void say() {
			System.out.println("안녕! 나는 원숭이야~");
		}
		
	}
	//내부 클래스(Inner Class) 2
	public class Tiger{
		public void roar() {
			System.out.println("어흥~~~");
		}
		
	}
	
	// 일반 메소드 출력하려면, 아래 new Zoo. x -> static 이 아니라서...  
	// public static void main () { 
	// 아래 이 메소드를 호출해서 멍키 타입 개체의 참조값을 얻어내려면?
	// Zoo z =new Zoo();
	// Monkey m = z.getMonkey(); // Zoo.monkey m = z.getMonkey();
	
	//메소드 (호출되면 Monkey 객체를 생성해서 리턴해 주는 메소드)
	public Monkey getMonkey() {
		return new Monkey();
	}
	//메소드 (호출되면 Tiger 객체를 생성해서 리턴해 주는 메소드)
	public Tiger getTiger() {
		return new Tiger();
	}

}
