package test.main;

import test.mypac.MemberInfo;

public class MainClass04_1 {
	public static void main(String[] args) {
		
		int num1=10;
		int num2=20;
		int num3=30;
		
		int[] nums = {num1, num2, num3};
		
		String name1="kim";
		String name2="lee";
		String name3="park";
		
		String[] names = {name1, name2, name3};
		
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
		MemberInfo[] members = {m1, m2, m3};
		
		MemberInfo[] members2 = {null, null, null};
		members2[0]=m1;
		members2[1]=m2;
		members2[2]=m3;
		
		MemberInfo[] members3 = new MemberInfo[3];
		members3[0]=m1;
		members3[1]=m2;
		members3[2]=m3;
		
	}
}
