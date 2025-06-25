package test.mypac;

public class MemberInfo {
	// 회원의 번호를 저장할 필드
	public int num;
	// 회원의 이름을 저장할 필드
	public String name;
	// 회원의 주소를 저장할 필드
	public String addr;
	
	// 필드에 저장된 정보를 콘솔창에 이쁘게 출력 해주는 메서드
	public void printData() {
		String data = "번호:"+this.num+" 이름:"+this.name+" 주소:"+this.addr;
		System.out.println(data);
	}
}
