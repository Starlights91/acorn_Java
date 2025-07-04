package test.frame;

import javax.swing.JFrame;

public class MemberFrame_NeedToUnderstand extends JFrame {
	
	// 객체 내부 (1. 여긴 heap 영역에 자신의 참조값 = id32 = this. [메소드] 사용 가능 ) this. = 객체 안에서는 생략가능!
	// 생성자
	public MemberFrame_NeedToUnderstand() {
//			this.setTitle("회원정보"); //1.
//			this.setBounds(100,100,800,500);
//			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//			this.setVisible(true);
		}

	// 객체 외부 (클래스 내부)
	public static void main(String[] args) { //
		MemberFrame_NeedToUnderstand f = new MemberFrame_NeedToUnderstand(); // 2. f 라는 지역변수 = stack = id32 참조
		f.setTitle("회원정보"); // 2.
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
