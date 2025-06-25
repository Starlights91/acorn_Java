package test.main;

import test.mypac.MemberInfo;

public class MainClass10 {
	public static void main(String[] args) {
		/*
		 * 1. MemberInfo 객체를 3개 생성해서 그 참조값을 m1, m2, m3 라는 변수에 각각 담아보자.(3줄)
		 * 2. m1, m2, m3 에 들어있는 참조값을 이용해서 3명의 회원정보를 각각의 객체에 담아보자. (9줄)
		 * 3. 각각의 객체가 가지고 있는 printData() 메소드를 호출 해보자. (3줄)
		 */
		MemberInfo m1 = new MemberInfo();
		MemberInfo m2 = new MemberInfo();
		MemberInfo m3 = new MemberInfo();
		
		m1.num=1800;
		m1.name="삼각김밥";
		m1.addr="GS25 신선식품냉장고";
		m2.num=2400;
		m2.name="몬스터 에너지";
		m2.addr="GS25 음료수냉장고";
		m3.num=1000;
		m3.name="호올스";
		m3.addr="GS25 진열대";
		
		
		
		m1.printData();
		m2.printData();
		m3.printData();
		
	}
}
