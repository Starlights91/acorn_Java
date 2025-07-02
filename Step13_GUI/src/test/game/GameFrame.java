package test.game;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	// 생성자
	public GameFrame() {
		setTitle("드래곤 플라이트");
		//부모 클래스가 JFrame 이기 때문에 JFrame. 은 생략 가능
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GamePanel gPanel=new GamePanel();
		add(gPanel);
		//GamePanel 객체가 선호하는 크기로 GameFrame 의 크기를 딱 맞게 조절하는 메소드
		pack();
		//프레임의 크기를 고정시키기
		setResizable(false);
		
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new GameFrame();
	}

}
