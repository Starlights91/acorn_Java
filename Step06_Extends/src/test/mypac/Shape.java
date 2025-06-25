package test.mypac;

// 가상의 도형(모양) 을 나타내는 객체를 생성할 클래스
public class Shape {
	// 도형의 위치
	private int x;
	private int y;
	
	// 생성자로 위치를 전달 받아서 필드에 저장하는 생성자
	// 생성자를 하나라도 정의하면 default 생성자는 없어진다 ( new Shape() 방식의 객체 생성 불가 )
	public Shape(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void printInfo() {
		System.out.println("x 좌표는: "+this.x+" y 좌표는: "+this.y);
	}
}
