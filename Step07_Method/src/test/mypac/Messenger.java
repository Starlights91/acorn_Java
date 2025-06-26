package test.mypac;

public class Messenger {
	
	// 글 하나를 전송하는 기능을 가지는 가상의 메소드
	public void sendPost(Post post) {
		System.out.println(post.getAuthor()+" 님이 작성한 글을 전송했습니다");
	}
}
