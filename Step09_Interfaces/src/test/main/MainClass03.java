package test.main;

// JAVA UI 구성해주는 
import javax.swing.JFrame;

public class MainClass03 {
	public static void main(String[] args) {
		
		// JAVA UI 구성해주는 객체 생성 (RUN 하면 UI 창이 새로 뜬다 -> 종료는 하단의 빨간색 정지버튼 클릭해야 종료!)
		JFrame f = new JFrame("나의 창");
		f.setBounds(100, 100, 500, 500); // 초기위치 2개 , 초기 크기 (가로, 세로)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		//f.setb
	}

}
