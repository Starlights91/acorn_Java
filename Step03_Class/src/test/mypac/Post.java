package test.mypac;

public class Post {
	// 글 번호를 저장할 필드
	public int id;
	// 글 내용을 저장할 필드
	public String content;
	// 글 작성자를 저장할 필드
	public String author;
	
	// 객체의 필드에 있는 정보를 이쁘게 출력 해주는 메소드
	public void printData() {
		/*
		 * 숫자(정수)는 %d
		 * 문자는 %s
		 * % % % 의 순서대로 들어간다.
		 */
		String data = String.format("번호:%d 내용:%s 작성자:%s ", this.id, this.content, this.author);
		System.out.println(data);
	}
}
