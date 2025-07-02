package test.frame02;

import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 *  Graphic User Interface = 윈도우 하나를 만들수 있는 클래스 설계하기
 *  
 *  1. JFrame 클래스를 상속 받는다. => extends JFrame 추가 => 이게 윕도우 창 틀을 만드는 것 (상속받아오면 적용됨)
 *  2. 생성자에서 필요한 초기화 작업을 한다.
 *  3. Main() 메소드에서 이클래스로 객체를 생성하면 프레임(window) 가 만들어진다.
 */
public class MyFrame extends JFrame{  //JFrame (부모)을 상속 받았기 때문에 하단의 메소드들을 사용할 수 있는것.
	// 생성자
	public MyFrame() { // 여기까지만 쓰고 this. fn+ctrl+space => 부모의 메소드들이 나온다.
		//프레임의 제목 설정
		this.setTitle("나의 프레임");
		//프레임의 위치와 크기 설정 setBounds(x, y, width, ehight)
		setBounds(100, 100, 500, 500);
		//종료(x)버튼을 눌렀을때 프로세스(app) 전체가 종료 되도록 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 클래스명.EXIT_ON_CLOSE = JFrame 클래스의 static 필드. ( EXIT_ON_CLOSE = static final 상수 = 3 (참조값), 의미없는 숫자에 이름을 부여한 효과)
		//레이아웃 매니저 객체 생성
		FlowLayout layout=new FlowLayout(FlowLayout.CENTER); // 클래스명.CENTER =FlowLayout 클래스의 static 필드. //FlowLayout= 물흐르듯 공간 없으면, 자동으로 하단으로 옮겨가도록. CENTER=가운데 정렬.  
		//프레임의 레이아웃 매니저 설정
		setLayout(layout); // setLayout 는 JFrame의 메소드
		//JButton 객체 생성
		JButton btn1=new JButton("버튼1");
		JButton btn2=new JButton("버튼2");
		JButton btn3=new JButton("버튼3");
		//add
		
		// (AI 에게 물어봐서 버튼이 동작하여 출력되도록 만들어보기!)
		// 버튼에 ActionListener 등록
		btn1.addActionListener(e -> System.out.println("버튼1을 눌렀네요!"));
		btn2.addActionListener(e -> System.out.println("버튼2을 눌렀네요!"));
		btn3.addActionListener(e -> System.out.println("버튼3을 눌렀네요!"));

//		btn1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼1을 눌렀네요!");
//			}
//			
//		});
//		
//		btn2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼2을 눌렀네요!");
//			}
//			
//		});
//		
//		btn3.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼3을 눌렀네요!");
//			}
//			
//		});
		

		//프레임의 add() 메소드 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치된다.
		add(btn1); // add 는 JFrame의 메소드
		add(btn2); 
		add(btn3); 
		
		
		//화면상에 실제 보이도록 한다.
		setVisible(true); //true(실제로 보임) 혹은 false(실제로 안보임) 로 변경 가능.	
	}
	//main 메소드 만들기 
	public static void main(String[] args) {
		 new MyFrame();
	}
}
