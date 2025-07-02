package test.gameTestMN.copy;

public class Monster {
	// 필드 초기값 int=0; 으로 시작해서 몬스터 위치 만들기
	private int x;
	private int y;
	//제거될 몬스터인지 여부 확인
	private boolean isRemove; // 초기값 isRemove=false
	// x 방향 (좌우 움직이는) 속도
	private int dx;
	
	
	// 디폴트 생성자
	public Monster(int x, int y, int dx) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		
	}

	// 필드에 저장할 값을 생성자로 전달 받을수 있는 생성자
	// 1. source - x, y 를 전달 받는 generate constructor using fields
	public Monster(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	// 2. source - generate setters & getters (필드가 위에 추가되면, 기존거 지우고 다시 만들기! 또는 그냥 추가된것만 더 추가하기!)
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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
		

}
