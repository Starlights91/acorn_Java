package test.main;

import test.mypac.Post;

public class MainClass04 {
	public static void main(String[] args) {
		// sendPost() 메소드를 호출해 보자.
		Post post=new Post(1, "title", "kim");
		Post post1=null;
		Post post2=new Post();
		Post p1=new Post();
		Post post3=p1;
		
		sendPost(post);
		sendPost(new Post());
		sendPost(new Post(2, "title", "park"));
		
		Post p2 = new Post();
		p2.setId(3);
		p2.setTitle("title2");
		p2.setAuthor("lee");
	}
	
	public static void sendPost(Post post) {
		System.out.println("글을 전송했습니다");
	}
}
