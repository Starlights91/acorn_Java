package test.mypac;

public class MemberDto {
	// 필드 정의하기 (접근 지정자가 private 로 되어 있으면 외부에서 접근 불가)
	// 동일 객체 내부에서만 접근 가능
	private int num;
	private String name;
	private String addr;
	
	
	// 클래스명과 동일하고 return type 이 명시되어 있지 않은 이것은 생성자(Constructor) 이다.
	// 객체를 new 하는 시점에 한번 호출된다.
	// 객체를 new 하는 시점에 무언가 초기화 작업을 할게 있으면 여기서 하면 된다.
	public MemberDto() {
		System.out.println("MemberDto 클래스의 생성자가 호출됨");
	}
	
	// 생성자는 필요에 따라서 다른 모양으로 여러개 정의할 수도 있다.
	public MemberDto(int num) {
		this.num=num;
	}
	
	// 만들어진 형식에 따른 생성자만 호출된다. (new Member(1, "Kim", "Busan")은 호출이 되지 않는다
	public MemberDto(int num, String name) {
		this.num=num;
		this.name=name;
	}
	
	// 필드에 저장된 회원의 번호를 리턴해주는 메소드
	public int getNum() {
		// 필드에 저장된 값 리턴하기
		return this.num;
	}
	
	// 필드에... 이름...
	public String getName() {
		return this.name;
	}
	
	// 필드에... 주소...
	public String getAddr() {
		return this.addr;
	}
	
	// 매개변수에 전달되는 회원의 번호를 필드에 저장하는 메소드
	public void setNum(int num) { // 매개변수도 data type 을 선언해야 한다.
								  // 매개변수가 선언되어 있으면 ()가 빈 상태로는 작동되지 않는다.
		// 매개변수(지역변수) num 에 담긴 값을 필드 num 에 대입하기
		this.num=num;
	}
	
	// 매개변수에 전달되는 회원의 이름을 필드에 저장하는 메소드를 만들어 보자.
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
