package test.mypac;

public class MemberInfo {
	public int num;
	public String name;
	public String addr;
	
	public void printData() {
		String data=String.format("번호:%d 이름:%s 주소:%s", this.num, this.name, this.addr);
		System.out.println(data);
	}
}
