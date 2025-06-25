package test.main;

import test.util.MyUtil;

public class MainClass05 {
	public static void main(String[] args) {
		// static 필드 참조
		String a=MyUtil.version;
		// static 메서드 호출
		MyUtil.send();
		
		MyUtil u1=new MyUtil();
		u1.owner="김구라";

		MyUtil u2=new MyUtil();
		u1.owner="해골";
		
		
	}
}
