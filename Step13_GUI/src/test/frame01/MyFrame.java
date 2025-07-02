package test.frame01;

import javax.swing.JFrame;

/*
 *  Graphic User Interface 를 만들수 있는 클래스 설계하기
 *  
 *  1. JFrame 클래스를 상속 받는다. => extends JFrame 추가 => 이게 윕도우 창 틀을 만드는 것 (상속받아오면 적용됨)
 *  2. 생성자에서 필요한 초기화 작업을 한다.
 *  3. Main() 메소드에서 이클래스로 객체를 생성하면 프레임(window) 가 만들어진다.
 */
public class MyFrame extends JFrame{
	// 생성자
	public MyFrame() { // 여기까지만 쓰고 this. fn+ctrl+space => 부모의 메소드들이 나온다.
		//프레임의 제목 설정
		this.setTitle("나의 프레임");
		//프레임의 위치와 크기 설정 setBounds(x, y, width, ehight)
		setBounds(100, 100, 500, 500);
		//종료(x)버튼을 눌렀을때 프로세스(app) 전체가 종료 되도록 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면상에 실제 보이도록 한다.
		setVisible(true); //true(실제로 보임) 혹은 false(실제로 안보임) 로 변경 가능.	
	}
}
