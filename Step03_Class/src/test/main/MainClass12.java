package test.main;

import test.mypac.Post;

public class MainClass12 {
	public static void main(String[] args) {
		// Post 객체를 생성해서
		Post p1=new Post();
		// 객체의 필드에 값을 담고
		p1.id=1;
		p1.content="hello";
		p1.author="kim";
		
		// 객체의 메소드를 호출하면 해당 객체가 가지고 있는 정보가 콘솔에 이쁘게 출력된다.
		p1.printData();
		
		
		Post p2=new Post();
		p2.id=2;
		p2.content="hi";
		p2.author="park";
		p2.printData();
	}
}
