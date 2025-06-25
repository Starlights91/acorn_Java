package test.main;

import test.mypac.Post;

public class MainClass08 {
	public static void main(String[] args) {
		// 1. Post 객체를 생성해서 참조값을 p1 이라는 변수에 담아보자.
		Post p1 = new Post();
		// 2. 글번호 1000 을 위에서 생성한 객체에 담아보자.
		p1.id=1000;
		// 3. 글내용 "안녕하세요!" 를 위에서 생성한 객체에 담아보자.
		p1.content="안녕하세요!";
		// 4. 작성자 "원숭이" 를 위에서 생성한 객체에 담아 보자.
		p1.author="원숭이";
		// 5. 위의 작업이 끝나면 debug 모드로 실행해서 동작을 확인 해보자.
	}
}
