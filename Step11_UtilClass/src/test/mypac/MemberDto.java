package test.mypac;

// MemberDto는 회원목록 
public class MemberDto {
	//필드 선언
	private int num;
	private String name;
	private String addr;
	
	// No Args Constructor 
	public MemberDto() {}
	
	// All Args Constructor (fields) //source > generate ...
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	
	// setter, getter 메소드 //source > generate ...
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	

}
