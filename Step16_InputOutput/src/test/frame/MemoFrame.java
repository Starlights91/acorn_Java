package test.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoFrame extends JFrame{
	
	//필요한 필드 정의하기
	JTextArea ta=new JTextArea();
	//현재 열린 파일 객체를 저장할 필드
	File openedFile;
	
	//생성자
	public MemoFrame(String title) {
		super(title);
		//메뉴바
		JMenuBar mb=new JMenuBar();
		//메뉴
		JMenu menu=new JMenu("File");
		//메뉴 아이템
		JMenuItem newItem=new JMenuItem("New");
		JMenuItem openItem=new JMenuItem("Open");
		JMenuItem saveItem=new JMenuItem("Save");
		JMenuItem saveAsItem=new JMenuItem("Save As");
		
		//처음에 저장기능은 disable 된 상태로 초기값을 만든다 (아직 메모장을 작성하지 않은 상태라서 비활성화 하는 것)
		saveItem.setEnabled(false);
		saveAsItem.setEnabled(false);
		
		//메뉴에 메뉴 아이템을 순서대로 추가 
		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(saveAsItem);
		
		//메뉴를 메뉴바에 추가 
		mb.add(menu);
		//프레임의 메소드를 이용해서 메뉴바를 추가하기 
		setJMenuBar(mb);
		//레이아웃 설정
		setLayout(new BorderLayout());
		
		//스크롤 페널
		JScrollPane scp=new JScrollPane(ta);
		//프레임의 가운데에 JScrollPane 을 배치하기 
		add(scp, BorderLayout.CENTER);
		
		//JTextArea 의 글자크기 조절하기
		Font font=new Font("Serif", Font.PLAIN, 30);
		ta.setFont(font);
		//처음에는 JTextArea 를 안보이게 설정
		ta.setVisible(false);
		
		// new 를 눌렀을때
		newItem.addActionListener((e)->{
			ta.setVisible(true); //처음에는 ta.setVisible(false); 라서 안보임. -> file 에서 new 누르면, 여기 함수가 실행되어 보이는 것!)  
			//프레임의 제목 바꾸기
			setTitle("제목 없음");
			//new 를 눌렀을 떄 saveAs 버튼만 활성화.
			saveAsItem.setEnabled(true);
		});
		
		//Save As 를 눌렀을때
		saveAsItem.addActionListener((e)->{
			//파일 선택을 하게 해주는 객체 생성
			var fc=new JFileChooser();
			//파일을 저장하게 하는 다이얼로그 띄우기 
			int result=fc.showSaveDialog(this); // int 정수값을 리턴 -> 사용자가 버튼을 눌렀을 때 어떤 동작
			//만일 제대로 파일을 만들 준비를 했다면
			if(result == JFileChooser.APPROVE_OPTION) {
				//해당 File 객체를 얻어오기
				openedFile=fc.getSelectedFile();
				//프레임의 title 로 파일명을 출력 
				setTitle(openedFile.getName()); // 여기까지작성하면 파일 실행
				//실제로 해당 파일 만들기 (openedFile.createNewFile(); 입력하고, 에러뜬 부분 위에서 -> surround with try/catch)
				try {
					openedFile.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//파일에 저장하는 메소드 호출
				saveToFile();
			}
		});
	}
	//현재까지 JTextArea 에 입력한 내용을 읽어와서 openedFile 에 저장하는 메소드
	public void saveToFile() {
		//JTextArea 에 입력한 문자열을 읽어와서
		String memo=ta.getText();
		//FileWriter 객체를 이용해서 openedFile 객체에 문자열이 저장되도록 한다.
		try(
			var fw=new FileWriter(openedFile);
		){
			fw.append(memo);
			fw.flush();
			JOptionPane.showMessageDialog(this, "저장했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 MemoFrame f=new MemoFrame("메모장");
		 f.setBounds(100, 100, 500, 500);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setVisible(true);
	}
}








