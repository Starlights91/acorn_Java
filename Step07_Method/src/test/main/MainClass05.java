package test.main;

import test.mypac.Messenger;
import test.mypac.Post;

public class MainClass05 {
	public static void main(String[] args) {
		// Messenger type 객체의 sendPost() 메소드를 호출
		// 실행했을 때 Exception 이 발생하지 않아야 한다.
		Messenger msgr = new Messenger();
		msgr.sendPost(new Post(1, "title", "kim2"));
	}
}
