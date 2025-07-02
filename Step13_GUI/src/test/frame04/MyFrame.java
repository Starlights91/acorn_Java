package test.frame04;

// 필요한 클래스 모두 import
import java.awt.FlowLayout; // 레이아웃(컴포넌트 배치 관리자)
import java.awt.event.ActionEvent; // 버튼 클릭시 발생하는 이벤트객체
import java.awt.event.ActionListener; // 클릭 이벤트 처리 위한 인터페이스

import javax.swing.JButton; //버튼 컴포넌트
import javax.swing.JFrame; //윈도우 프레임

// JFrame 을 상속받고 & ActionListener 인터페이스를 구현(implements)
public class MyFrame extends JFrame implements ActionListener {
	// 필드 (countBtn & count 를 특정 {} 생성자를 벗어나서도 사용할 수 있도록 하기 위함.??
	//버튼의 참조값을 담을 필드
	private JButton countBtn; // 버튼을 필드로 선언
	//버튼을 누른 횟수를 저장할 필드
	private int count = 0; // 카운트를 저장할 필드

	// 생성자
	public MyFrame() {
		setTitle("나의 프레임"); // 프레임(창)의 제목 설정
		setBounds(100, 100, 300, 300); // 프레임의 위치(x,y)와 크기(width,height) 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 누르면 프로그램 종료
		
		// FlowLayout 레이아웃 매니저 객체 생성 (중앙정렬)
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		// 프레임 레이아웃 매니저 설정
		setLayout(layout);
		
		//생성한 버튼의 참조값을 필드에 저장하면 객체안에서 어디서든지 활용가능!
		// (나) this. 제거하고 => countBtn = new JButton("0"); 으로 사용 가능! 
		// (나) 같은 클래스 안에서 필드에 접근할 때 this. 생략 가능! this.를 굳이 쓴 이유는 필드란 걸 명확하게 표현하기 위함!
		this.countBtn = new JButton("0"); // 버튼 생성 (초기값 "0" 표시)
		add(countBtn); // 버튼을 프레임에 추가
		
		// 버튼의 setText() 메소드를 이용하면 버튼에 출력된 문자열을 변경할 수 있다.
		// countBtn.setText("1"); // 버튼 누를때마다 1씩 증가하도록 만들어 보기!

		countBtn.addActionListener(this); // 버튼 클릭시 이벤트를 받을 리스너 등록

		setVisible(true); // 프레임이 화면에 보이도록 설정
	}
	
	// 프로그램 실행 진입점이 되는 곳!
	public static void main(String[] args) {
		new MyFrame(); // MyFrame 객체 생성(= 위에 생성한 "생성자 호출!)
		
	}
	
	 //버튼이 클릭될 때 자동으로 호출되는 콜백 메소드 => public class MyFrame extends JFrame implements ActionListener { 여기에서 ActionListener 를 
	@Override
	public void actionPerformed(ActionEvent e) {
		//count 값을 1증가 시킨다.
		count++; // 버튼 클릭 횟수 증가
		//버튼의 text 를 변경하려면 생성자에서 new JButton() 했던 참조값을 여기서 사용할 수 있어야 한다.
		countBtn.setText(Integer.toString(count)); // 버튼 누를때마다 1씩 증가 // 버튼의 문자열을 count 값으로 변경
		

		}	
	
}
