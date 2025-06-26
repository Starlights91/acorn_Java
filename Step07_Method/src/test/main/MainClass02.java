package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// String type 을 매개변수에 전달하면서 메소드 호출
		sendMessage("메세지래요");
		sendMessage("bye");
		
		String str="kimgura";
		// 이미 만들어진 변수에 있는 내용을 변수명으로 전달
		sendMessage(str);
	}
	
	public static void sendMessage(String msg) {
		System.out.println(msg+"를 전송했습니다");
		
	}
}
