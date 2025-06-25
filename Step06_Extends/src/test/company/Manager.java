package test.company;

public class Manager extends Employee{
	private String position; // ex: "팀장", "부장", "이사"

	// 생성자
	public Manager(String name, int salary, Department dept) {
		super(name, salary, dept); //부모의 생성자 매개변수
		
	}
	// 필드에 값을 넣어주는 setter 메소드
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("매니저의 직책: "+position);
	}
	
}
