package test.game;

public class Missile {
	private int x; //초기값 int = 0 
	private int y; // private x,y 라서 setter&getter 로 만들어야 함.
	//제거할 미사일인지 여부
	private boolean isRemove; // 초기값 isRemove=false  // true 이면 제거, false 이면 살아남는 
	
	// 디폴트 생성자
	public Missile() {}
	
	// 필드에 저장할 값을 생성자로 전달 받을수 있는 생성자
	// source - x, y 를 전달 받는 generate constructor using fields
	public Missile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	//필드 접근 메소드 setter & getter
	// source - generate setters & getters (필드가 위에 추가되면, 기존거 지우고 다시 만들기!)
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isRemove() {
		return isRemove;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}
	
	
	

}
