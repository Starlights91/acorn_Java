package test.mypac;

public interface Remocon {
	// only static field 
	// only abstract
	/*
	 * 	필드도 가질수 있지만 static final 만 가능하다
	 *  static : static 영역에 Remocon 인터페이스와 같이 만들어진다	
	 *  final : 값이 결정된 이후에 변경 불가능(상수화 시킨다)
	 * 	생략가능
	 */
	public String COMPANY="LG"; // static final 상수는 관례상 필드명을 모두 대문자로.
	// 위의 코드를 참조할 땐 interface명에 . 점 찍어서 참조 할수 있다.
	
	
	//인터페이스는 추상 메소드만 정의할수있다. abstract 예약어 안붙여도 됨
	public void up(); // 추상메소드
	public void down(); 
	
	
	

}
