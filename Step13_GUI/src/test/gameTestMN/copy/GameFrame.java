package test.gameTestMN.copy;

import javax.swing.JFrame;

//JFrame 부모로부터 상속받아서 메소드 만든 것. 
public class GameFrame extends JFrame {
	
	// 생성자 (아래의 메소드는 " this. " 이 모두 생략 된 것. this.setTitle
	public GameFrame() {
		setTitle("드래곤 플라이트"); // 제목 설정
		//부모 클래스가 JFrame 이기 때문에 JFrame. 은 생략 가능
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x 표시 누르면 앱의 프로세스가 종료되도록 설정
		
		GamePanel gPanel=new GamePanel(); // GamePanel 은 JPanel 상속받아서 사용. 클래스 안에 또 세부 설계도를 만듦
		add(gPanel);
		//GamePanel 객체가 선호하는 크기로 GameFrame 의 크기를 딱 맞게 조절하는 메소드
		pack();
		//프레임의 크기를 고정시키기
		setResizable(false);
		
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new GameFrame(); //게임 객체 생성 = run = UI(GameFrame)을 만들어준다.
	}

}
