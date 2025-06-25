package test.main;

import test.mypac.MemberInfo;

public class MainClass05 {
	public static void main(String[] args) {
		MemberInfo m1=new MemberInfo();
		m1.num=1;
		m1.name="김구라";
		m1.addr="노량진";
		
		MemberInfo m2=new MemberInfo();
		m2.num=2;
		m2.name="해골";
		m2.addr="행신동";
		
		MemberInfo m3=new MemberInfo();
		m3.num=3;
		m3.name="원숭이";
		m3.addr="동물원";
		
		// 위에서 생성한 MemberInfo 객체의 참조값 3개를 배열에 순서대로 담아보자.
		MemberInfo[] members= {m1, m2, m3};
		
		MemberInfo[] a = members;   // 배열
		MemberInfo b = members[0];  // 배열의 0번방 MemberInfo 객체
		int c = members[0].num;	    // 회원의 번호 1
		String d = members[0].name; // 회원의 이름 "김구라"
		String e = members[0].addr; // 회원의 주소 "노량진"
		members[0].printData();     // 메소드 호출
	}
}
