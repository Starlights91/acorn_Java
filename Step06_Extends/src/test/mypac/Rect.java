package test.mypac;

public class Rect extends Shape{
	// 사각형의 변의 길이를 저장할 필드
	private int side;
	
	public Rect(int x, int y,int side) {
		super(x, y);
		this.side=side;
	}
	public void printArea() {
		double area = side*side;
		System.out.println("정사각형의 넓이는: "+area);
	}
	
	@Override	
	public void printInfo() {
		super.printInfo();
		System.out.println("한 변의 길이는: "+side);
	}
	

}
