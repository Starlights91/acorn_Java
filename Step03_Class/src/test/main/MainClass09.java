package test.main;

import test.mypac.MemberInfo;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 1. 한명의 회원정보를 MemberInfo 객체에 담아보자.
		 * ( 번호, 이름, 주소 는 본인 마음대로 )
		 */
		MemberInfo info = new MemberInfo();
		info.num=1800;
		info.name="삼각김밥";
		info.addr="GS25";
		
		// 2. 위에서 생성한 객체(MemberInfo) 의 pintData() 메소드를 호출.
		info.printData();
	}
}
