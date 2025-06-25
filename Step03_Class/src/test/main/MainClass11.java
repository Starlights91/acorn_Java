package test.main;

import test.mypac.Post;

public class MainClass11 {
	public static void main(String[] args) {
		Post p1=null;
		Post p2=new Post();
		Post p3=p2;
		
		// 위의 3줄을 실행하면 Post 객체는 총 몇개가 생성될까?
		
		p2.id=1;
		p2.content="hello";
		p2.author="kim";
		
		System.out.println(p3.content);
	}
}
